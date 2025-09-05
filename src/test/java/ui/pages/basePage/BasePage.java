package ui.pages.basePage;

import core.context.service.IContextService;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public abstract class BasePage implements IBasePage, IContextService {

  public void openPage(String url) {
    open(url);
  }

  public void verifyPageUrl(String url) {
    webdriver().shouldHave(url(url));
  }

  public void verifyTextOfElement(By locator, String text) {
    $(locator).shouldHave(text(text));
  }
}