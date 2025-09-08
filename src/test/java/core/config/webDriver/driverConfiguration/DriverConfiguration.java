package core.config.webDriver.driverConfiguration;

import com.codeborne.selenide.Configuration;
import core.config.webDriver.webDriverSingleton.WebDriverSingleton;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.EDGE;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class DriverConfiguration {
  static WebDriverSingleton webDriverSingleton;

  static {
    try {
      webDriverSingleton = WebDriverSingleton.getInstance();
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
    Configuration.browserSize = webDriverSingleton.getWebDriverConfig().getBrowserScreenSize().trim();
    Configuration.timeout = webDriverSingleton.getWebDriverConfig().getTimeoutMilliseconds();
    Configuration.pageLoadTimeout = webDriverSingleton.getWebDriverConfig().getPageLoadedTimeoutMilliseconds();
    Configuration.pageLoadStrategy = webDriverSingleton.getWebDriverConfig().getPageLoadStrategy();
  }

  public static void setupDriver() {
    configureBrowser();
    configureBrowserProperties();
  }
}