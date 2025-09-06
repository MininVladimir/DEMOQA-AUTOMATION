package core.listener.screenshotListener;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public interface IScreenshotListener {

  static void addScreenshotListener() {
    SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));
  }

  static void removeScreenshotListener() {
    SelenideLogger.removeListener("allure");
  }
}