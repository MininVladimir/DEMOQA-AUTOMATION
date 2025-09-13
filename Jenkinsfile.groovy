pipeline {
    agent any
    tools {
        maven 'Maven-3.8.6'
        jdk 'JDK 21'
    }
    parameters {
        choice(name: 'browser', choices: ['chrome', 'firefox', 'edge'], description: 'Browser to run UI tests')
        booleanParam description: 'Run browser in headless mode or not', name: 'headless'
    }
    options {
        timestamps()
        skipDefaultCheckout()
    }
    environment {
        MVN_HOME = tool name: 'Maven-3.8.6'
        JAVA_HOME = tool name: 'JDK 21'
    }
    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Github integration') {
            steps {
                checkout([
                        $class: 'GitSCM',
                        branches: [[name: 'refs/heads/master']],
                        userRemoteConfigs: [[url: 'https://github.com/MininVladimir/DEMOQA-AUTOMATION']]
                ])
            }
        }
        stage('Build and test') {
            steps {
                wrap([$class: 'Xvfb', screen: '1600x900x24']) {
                    withMaven(jdk: 'JDK 21', maven: 'Maven-3.8.6', traceability: true) {
                        script {
                            sh """
                                mvn clean test \
                                    -Dselenide.browserName=${browser} \
                                    -Dselenide.headlessMode=${headless}
                            """
                        }
                    }
                }
            }
        }
        stage('Generate Report') {
            steps {
                allure includeProperties: false,
                        results: [[path: 'allure-results']]
            }
        }
    }
    post {
        always {
            cleanWs()
        }
        success {
            echo 'Build and tests are successful.'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}