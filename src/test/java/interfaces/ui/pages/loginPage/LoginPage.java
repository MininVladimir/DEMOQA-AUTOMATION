package interfaces.ui.pages.loginPage;

import interfaces.ui.pages.basePage.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
  private final By usernameInput = By.id("userName");
  private final By passwordInput = By.id("password");
  private final By loginButton = By.id("login");
  private final By pageTitle = By.xpath("//h1[@class = 'text-center']");

  public void setUserNameInput(String userName) {
    setInput(usernameInput, userName);
  }

  public void setPasswordInput(String password) {
    setInput(passwordInput, password);
  }

  public void loginButtonClick() {
    elementClick(loginButton);
  }

  public void verifyPageTitle(String text) {
    verifyTextOfElement(pageTitle, text);
  }
}