
`...IN PROGRESS`

# DEMOQA AUTOMATION PROJECT

## Overview

This framework is designed for UI and API testing.

## Documentation

Test scenarios are located in `src/test/java/docs`

## Requirements

- Java JDK version 21 or higher
- Maven 3.6+
- Browsers: Chrome, Firefox, Edge

## Libraries Used

- Maven
- Selenium 4.35.0
- Selenide 7.10.0
- Rest Assured 5.5.6
- JUnit 5.10.2
- Allure 2.25.0
- Jackson 2.18.2

## Configuration

This framework provides a flexible configuration for reading WebDriver properties that supports `YAML`
file format.

### Runtime system properties

| System property       | Possible values         | Default value | Description                         |
|-----------------------|-------------------------|---------------|-------------------------------------|
| selenide.browserName  | chrome / firefox / edge | chrome        | Browser to run UI tests             |
| selenide.headlessMode | true / false            | false         | Run browser in headless mode or not |

## Usage

Run tests in the terminal with:

```bash
mvn clean test "-Dselenide.browserName=firefox" "-Dselenide.headlessMode=true"
```
or 
```bash
mvn clean test
```

Watch report in the terminal with:
```bash
allure serve
```