package interfaces.ui.steps;

import core.context.ContextHolder;
import interfaces.api.user.controller.UserController;
import interfaces.ui.pages.loginPage.LoginPage;
import io.qameta.allure.Step;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.LOGIN_PAGE_URL;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;

public class LoginPageSteps {
  static LoginPage loginPage = new LoginPage();

  @Step("[UI] Set 'UserName' input")
  private static void setUserNameInput() {
    loginPage.setUserNameInput(ContextHolder.getContext().getUsername());
  }

  @Step("[UI] Set 'Password' input")
  private static void setPasswordInput() {
    loginPage.setPasswordInput(ContextHolder.getContext().getPassword());
  }

  @Step("[UI] Click 'Login' button'")
  private static void registerButtonClick() {
    loginPage.loginButtonClick();
  }

  @Step("[UI] Verify visibility of 'Login' button")
  private static void verifyVisibilityOfLoginButton() {
    loginPage.verifyVisibilityOfLoginButton();
  }

  @Step("[UI] Verify [Login] page url")
  public static void verifyLoginPageUrl() {
    loginPage.verifyPageUrl(getApplicationConfigValue(LOGIN_PAGE_URL));
  }

  @Step("[UI] Login")
  public static void login() {
    setUserNameInput();
    setPasswordInput();
    registerButtonClick();
  }

  @Step("[UI] Open [Login] page")
  public static void openLoginPage() {
    loginPage.openPage(getApplicationConfigValue(LOGIN_PAGE_URL));
  }

  @Step("[UI] Verify [Login] page is opened")
  public static void verifyLoginPageIsOpened() {
    verifyLoginPageUrl();
    verifyVisibilityOfLoginButton();
  }
}