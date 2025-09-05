package ui.tests.baseTest;

import com.codeborne.selenide.Configuration;
import core.config.webDriver.webDriverSingleton.WebDriverSingleton;
import core.context.ui.UiContextHolder;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.localStorage;

public interface IUiBaseTest {

  @Step("Setup driver")
  static void setupDriver() throws Exception {
    Configuration.browser = WebDriverSingleton.getInstance().getWebDriverConfig().getBrowser().toUpperCase().trim();
    Configuration.headless = WebDriverSingleton.getInstance().getWebDriverConfig().isHeadlessMode();
    Configuration.browserSize = WebDriverSingleton.getInstance().getWebDriverConfig().getBrowserScreenSize().trim();
    Configuration.timeout = WebDriverSingleton.getInstance().getWebDriverConfig().getTimeoutMilliseconds();
    Configuration.pageLoadTimeout = WebDriverSingleton.getInstance().getWebDriverConfig().getPageLoadedTimeoutMilliseconds();
    Configuration.pageLoadStrategy = WebDriverSingleton.getInstance().getWebDriverConfig().getPageLoadStrategy();
  }

  @Step("Remove context")
  default void removeContext() {
    UiContextHolder.removeContext();
  }

  @Step("Clear local storage")
  default void clearLocalStorage() {
    localStorage().clear();
  }

  @Step("Close driver")
  static void closeDriver() {
    closeWebDriver();
  }
}