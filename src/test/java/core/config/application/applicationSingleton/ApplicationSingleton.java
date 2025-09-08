package core.config.application.applicationSingleton;

import core.config.application.dto.ApplicationConfig;

import static core.parser.Parser.parseFileAsModelClass;

public class ApplicationSingleton {
  private static ApplicationSingleton instance;
  private final static String filePath = "src/test/resources/config/application/applicationConfig.yaml";

  private final ApplicationConfig applicationConfig;

  public ApplicationSingleton() throws Exception {
    applicationConfig = parseFileAsModelClass(filePath, ApplicationConfig.class);
    if (applicationConfig == null) {
      throw new Exception();
    }
  }

  public static synchronized ApplicationSingleton getInstance() throws Exception {
    if (instance == null) {
      instance = new ApplicationSingleton();
    }
    return instance;
  }

  public ApplicationConfig getApplicationConfig() {
    return applicationConfig;
  }
}