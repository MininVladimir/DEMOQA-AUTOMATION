package interfaces.ui.steps;

import core.context.ui.UiContextHolder;
import interfaces.api.user.controller.UserController;
import interfaces.ui.pages.loginPage.LoginPage;
import io.qameta.allure.Step;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.LOGIN_PAGE_URL;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static enums.ContextType.UI;

public class LoginPageSteps {
  static UserController userController = new UserController();
  static LoginPage loginPage = new LoginPage();

  @Step("[UI] Set 'UserName' input")
  private static void setUserNameInput() {
    loginPage.setUserNameInput(UiContextHolder.getContext().getUsername());
  }

  @Step("[UI] Set 'Password' input")
  private static void setPasswordInput() {
    loginPage.setPasswordInput(UiContextHolder.getContext().getPassword());
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

  @Step("[API] Registration")
  public static void registration() {
    userController.registration(UI.getContextType());
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