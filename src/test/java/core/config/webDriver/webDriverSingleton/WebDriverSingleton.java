package core.config.webDriver.webDriverSingleton;

import core.config.webDriver.dto.WebDriverConfig;

import static core.parser.Parser.parseFileAsModelClass;

public class WebDriverSingleton {

  private static WebDriverSingleton instance;
  private final static String filePath = "src/test/resources/config/webDriverConfig.yaml";

  private final WebDriverConfig webDriverConfig;

  public WebDriverSingleton() throws Exception {
    webDriverConfig = parseFileAsModelClass(filePath, WebDriverConfig.class);
    if (webDriverConfig == null) {
      throw new Exception();
    }
  }

  public static synchronized WebDriverSingleton getInstance() throws Exception {
    if (instance == null) {
      instance = new WebDriverSingleton();
    }
    return instance;
  }

  public WebDriverConfig getWebDriverConfig() {
    return webDriverConfig;
  }
}