package interfaces.ui.pages.basePage;

import core.context.IContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public abstract class BasePage implements IBasePage, IContext {

  public void openPage(String url) {
    open(url);
  }

  public void verifyPageUrl(String url) {
    webdriver().shouldHave(url(url));
  }

  public void verifyTextOfElement(By locator, String text) {
    $(locator).shouldHave(text(text));
  }

  public void setInput(By locator, String text) {
    $(locator).clear();
    $(locator).setValue(text);
  }

  public void captchaByPass(By captchaFrameLocator, By captchaAnchorLocator) {
    switchTo().frame($(captchaFrameLocator));
    $(captchaAnchorLocator).click();
    $(captchaAnchorLocator).shouldHave(attribute("aria-disabled", "false"));
    switchTo().defaultContent();
  }

  public void elementClick(By locator) {
    $(locator).click();
  }

  public void verifyAlertMessage(String expectedResult) {
    Assertions.assertEquals(expectedResult, switchTo().alert().getText());
  }

  public void verifyVisibilityOfElement(By locator) {
    $(locator).shouldBe(visible);
  }

  public void acceptAlert() {
    switchTo().alert().accept();
  }
}