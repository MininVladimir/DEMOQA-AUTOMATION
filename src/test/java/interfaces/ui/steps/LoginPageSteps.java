package interfaces.ui.steps;

import core.context.ui.UiContextHolder;
import interfaces.api.registration.controller.UserRegistrationController;
import interfaces.ui.pages.loginPage.LoginPage;
import io.qameta.allure.Step;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.ConfigKey.LOGIN_PAGE_URL;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static enums.ContextType.UI;

public class LoginPageSteps {
  static UserRegistrationController userRegistrationController = new UserRegistrationController();
  static LoginPage loginPage = new LoginPage();

  @Step("[UI] Set 'userName' input")
  private static void setUserNameInput() {
    loginPage.setUserNameInput(UiContextHolder.getContext().getUsername());
  }

  @Step("[UI] Set 'password' input")
  private static void setPasswordInput() {
    loginPage.setPasswordInput(UiContextHolder.getContext().getPassword());
  }

  @Step("[UI] Click 'login' button'")
  private static void registerButtonClick() {
    loginPage.loginButtonClick();
  }

  @Step("[UI] Verify [Login] page url")
  private static void verifyLoginPageUrl() {
    loginPage.verifyPageUrl(getApplicationConfigValue(LOGIN_PAGE_URL));
  }

  @Step("[UI] Verify [Login] page title")
  private static void verifyLoginPageTitle() {
    loginPage.verifyPageTitle("Login");
  }

  @Step("[UI] Login")
  public static void login() {
    setUserNameInput();
    setPasswordInput();
    registerButtonClick();
  }

  @Step("[API] Registration")
  public static void registration() {
    userRegistrationController.registration(UI.getContextType());
  }

  @Step("[UI] Open [Login] page")
  public static void openLoginPage() {
    loginPage.openPage(getApplicationConfigValue(LOGIN_PAGE_URL));
  }

  @Step("[UI] Verify [Login] page is opened")
  public static void verifyLoginPageIsOpened() {
    verifyLoginPageUrl();
    verifyLoginPageTitle();
  }
}