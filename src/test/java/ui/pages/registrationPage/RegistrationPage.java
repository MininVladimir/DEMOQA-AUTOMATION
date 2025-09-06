package ui.pages.registrationPage;

import org.openqa.selenium.By;
import ui.pages.basePage.BasePage;

public class RegistrationPage extends BasePage {
  private final By captchaFrame = By.xpath("//iframe[@title = 'reCAPTCHA']");
  private final By firstNameInput = By.id("firstname");
  private final By lastNameInput = By.id("lastname");
  private final By usernameInput = By.id("userName");
  private final By passwordInput = By.id("password");
  private final By captchaAnchor = By.id("recaptcha-anchor");
  private final By registerButton = By.id("register");

  public void captchaConfirm() {
    captchaByPass(captchaFrame, captchaAnchor);
  }

  public void setFirstNameInput(String firstName) {
    setInput(firstNameInput, firstName);
  }

  public void setLastNameInput(String lastName) {
    setInput(lastNameInput, lastName);
  }

  public void setUserNameInput(String userName) {
    setInput(usernameInput, userName);
  }

  public void setPasswordInput(String password) {
    setInput(passwordInput, password);
  }

  public void registerButtonClick() {
    elementClick(registerButton);
  }
}