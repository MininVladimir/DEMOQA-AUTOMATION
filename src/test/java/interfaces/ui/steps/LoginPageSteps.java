package interfaces.ui.steps;

import core.context.ui.UiContextHolder;
import interfaces.api.registration.controller.UserRegistrationController;
import interfaces.ui.pages.loginPage.LoginPage;
import io.qameta.allure.Step;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.getLoginPageUri;
import static enums.ContextType.UI;

public class LoginPageSteps {
  static UserRegistrationController userRegistrationController = new UserRegistrationController();
  static LoginPage loginPage = new LoginPage();

  @Step("Set userName input")
  private static void setUserNameInput() {
    loginPage.setUserNameInput(UiContextHolder.getContext().getUsername());
  }

  @Step("Set password input")
  private static void setPasswordInput() {
    loginPage.setPasswordInput(UiContextHolder.getContext().getPassword());
  }

  @Step("Login button click")
  private static void registerButtonClick() {
    loginPage.loginButtonClick();
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

  @Step("[UI] Open login page")
  public static void openLoginPage() {
    loginPage.openPage(getLoginPageUri());
  }
}