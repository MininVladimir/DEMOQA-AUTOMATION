package interfaces.ui.tests.baseTest;

import core.config.webDriver.webDriverConfigReader.WebDriverConfigReader;
import core.context.ui.UiContextHolder;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.localStorage;

public interface IUiBaseTest {

  @Step("Setup driver")
  static void setupDriver() {
    WebDriverConfigReader.setupDriver();
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