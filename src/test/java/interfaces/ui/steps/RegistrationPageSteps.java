package interfaces.ui.steps;

import core.context.IContext;
import core.context.ContextHolder;
import interfaces.ui.pages.registrationPage.RegistrationPage;
import io.qameta.allure.Step;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.REGISTRATION_PAGE_URL;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static enums.ResultType.USER_REGISTER_SUCCESSFULLY;

public class RegistrationPageSteps implements IContext {
  static RegistrationPage registrationPage = new RegistrationPage();

  @Step("Generate user data")
  private static void generateUserData() {
    IContext.setFirstNameToContext();
    IContext.setLastNameToContext();
    IContext.setUserUsernameToContext();
    IContext.setPasswordToContext();
  }

  @Step("[UI] Open [Registration] page")
  private static void openRegistrationPage() {
    registrationPage.openPage(getApplicationConfigValue(REGISTRATION_PAGE_URL));
  }

  @Step("[UI] Set 'firstName' input")
  private static void setFirstnameInput() {
    registrationPage.setFirstNameInput(ContextHolder.getContext().getFirstname());
  }

  @Step("[UI] Set 'lastName' input")
  private static void setLastNameInput() {
    registrationPage.setLastNameInput(ContextHolder.getContext().getLastname());
  }

  @Step("[UI] Set 'userName' input")
  private static void setUserNameInput() {
    registrationPage.setUserNameInput(ContextHolder.getContext().getUsername());
  }

  @Step("[UI] Set 'password' input")
  private static void setPasswordInput() {
    registrationPage.setPasswordInput(ContextHolder.getContext().getPassword());
  }

  @Step("[UI] Captcha confirm")
  private static void captchaConfirm() {
    registrationPage.captchaConfirm();
  }

  @Step("[UI] Click 'Register' button")
  private static void registerButtonClick() {
    registrationPage.registerButtonClick();
  }

  @Step("[UI] Verify alert message")
  private static void verifyAlertMessage() {
    registrationPage.verifyAlertMessage(USER_REGISTER_SUCCESSFULLY.getResult());
  }

  @Step("[UI] Registration")
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