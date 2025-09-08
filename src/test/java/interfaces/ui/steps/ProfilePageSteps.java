package interfaces.ui.steps;

import interfaces.api.authorization.controller.UserAuthorizationController;
import interfaces.api.registration.controller.UserRegistrationController;
import interfaces.ui.pages.privateArea.ProfilePage;
import io.qameta.allure.Step;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.getFaviconUri;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getProfilePageUri;
import static enums.ContextType.UI;

public class ProfilePageSteps {
  static UserRegistrationController userRegistrationController = new UserRegistrationController();
  static UserAuthorizationController userAuthorizationController = new UserAuthorizationController();
  static ProfilePage profilePage = new ProfilePage();

  @Step("[API] Generate token")
  private static void generateToken() {
    userAuthorizationController.generateToken(UI.getContextType());
  }

  @Step("[API] Send credentials")
  private static void sendCredentials() {
    userAuthorizationController.sendCredentials(UI.getContextType());
  }

  @Step("[API] Authorization")
  private static void authorization() {
    userAuthorizationController.authorization(UI.getContextType());
  }

  @Step("[UI] Verify profile page url")
  private static void verifyProfilePageUrl() {
    profilePage.verifyPageUrl(getProfilePageUri());
  }

  @Step("[UI] Verify username")
  private static void verifyUsername() {
    profilePage.verifyUsername(UI.getContextType());
  }

  @Step("[UI] Verify profile page is opened")
  public static void verifyProfilePageIsOpened() {
    verifyProfilePageUrl();
    verifyUsername();
  }

  @Step("[UI] Open domain resource")
  public static void openDomainResource() {
    profilePage.openPage(getFaviconUri());
  }

  @Step("[API] Registration")
  public static void registration() {
    userRegistrationController.registration(UI.getContextType());
  }

  @Step("[API] Login")
  public static void login() {
    generateToken();
    sendCredentials();
    authorization();
  }

  @Step("[UI] Set auth user cookies and open user profile page")
  public static void setAuthUserCookiesAndOpenUserProfilePage() {
    profilePage.setAuthUserCookiesAndOpenUserProfilePage(getProfilePageUri());
    verifyProfilePageIsOpened();
  }
}