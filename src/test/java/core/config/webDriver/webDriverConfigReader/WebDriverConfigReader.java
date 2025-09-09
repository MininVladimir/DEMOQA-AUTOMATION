package core.config.webDriver.webDriverConfigReader;

import com.codeborne.selenide.Configuration;
import core.config.webDriver.dto.WebDriverConfig;
import core.config.webDriver.webDriverSingleton.WebDriverSingleton;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.EDGE;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class WebDriverConfigReader {
  static WebDriverConfig webDriverConfig;

  static {
    try {
      webDriverConfig = WebDriverSingleton.getInstance().getWebDriverConfig();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static void configureBrowser() {
    switch (System.getProperty("selenide.browserName").toLowerCase().trim()) {
      case "firefox" -> Configuration.browser = FIREFOX;
      case "edge" -> Configuration.browser = EDGE;
      default -> Configuration.browser = CHROME;
    }
  }

  private static void configureBrowserProperties() {
    Configuration.headless = Boolean.parseBoolean(System.getProperty("selenide.headlessMode").toLowerCase().trim());
    Configuration.browserSize = webDriverConfig.getBrowserScreenSize();
    Configuration.timeout = webDriverConfig.getTimeoutMilliseconds();
    Configuration.pageLoadTimeout = webDriverConfig.getPageLoadedTimeoutMilliseconds();
    Configuration.pageLoadStrategy = webDriverConfig.getPageLoadStrategy();
  }

  public static void setupDriver() {
    configureBrowser();
    configureBrowserProperties();
  }
}