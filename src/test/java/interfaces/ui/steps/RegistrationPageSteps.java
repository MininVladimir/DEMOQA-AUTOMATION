package interfaces.ui.steps;

import core.context.service.IContextService;
import core.context.ui.UiContextHolder;
import interfaces.ui.pages.registrationPage.RegistrationPage;
import io.qameta.allure.Step;

import static enums.ContextType.UI;
import static enums.ResultType.USER_REGISTER_SUCCESSFULLY;
import static enums.UriPageType.REGISTRATION_URI;

public class RegistrationPageSteps implements IContextService {
  static RegistrationPage registrationPage = new RegistrationPage();

  @Step("Generate user data")
  private static void generateUserData() {
    IContextService.setFirstNameToContext();
    IContextService.setLastNameToContext();
    IContextService.setUserUsernameToContext(UI.getContextType());
    IContextService.setPasswordToContext(UI.getContextType());
  }

  @Step("Open registration page")
  private static void openRegistrationPage() {
    registrationPage.openPage(REGISTRATION_URI.getUri());
  }

  @Step("Set firstName input")
  private static void setFirstnameInput() {
    registrationPage.setFirstNameInput(UiContextHolder.getContext().getFirstname());
  }

  @Step("Set lastName input")
  private static void setLastNameInput() {
    registrationPage.setLastNameInput(UiContextHolder.getContext().getLastname());
  }

  @Step("Set userName input")
  private static void setUserNameInput() {
    registrationPage.setUserNameInput(UiContextHolder.getContext().getUsername());
  }

  @Step("Set password input")
  private static void setPasswordInput() {
    registrationPage.setPasswordInput(UiContextHolder.getContext().getPassword());
  }

  @Step("Captcha confirm")
  private static void captchaConfirm() {
    registrationPage.captchaConfirm();
  }

  @Step("Register button click")
  private static void registerButtonClick() {
    registrationPage.registerButtonClick();
  }

  @Step("Verify alert message")
  private static void verifyAlertMessage() {
    registrationPage.verifyAlertMessage(USER_REGISTER_SUCCESSFULLY.getResult());
  }

  @Step("Registration user")
  public static void registration() {
    generateUserData();
    openRegistrationPage();
    setFirstnameInput();
    setLastNameInput();
    setUserNameInput();
    setPasswordInput();
    captchaConfirm();
    registerButtonClick();
    verifyAlertMessage();
  }
}