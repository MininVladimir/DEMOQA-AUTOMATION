package ui.steps;

import api.authorization.controller.UserAuthorizationController;
import api.registration.controller.UserRegistrationController;
import io.qameta.allure.Step;
import ui.pages.privateArea.ProfilePage;

import static enums.ContextType.UI;
import static enums.UriPageType.FAVICON_URI;
import static enums.UriPageType.PROFILE_URI;

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
    profilePage.verifyPageUrl(PROFILE_URI.getUri());
  }

  @Step("[UI] Verify username")
  private static void verifyUsername() {
    profilePage.verifyUsername(UI.getContextType());
  }

  @Step("[UI] Open domain resource")
  public static void openDomainResource() {
    profilePage.openPage(FAVICON_URI.getUri());
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
    profilePage.setAuthUserCookiesAndOpenUserProfilePage(PROFILE_URI.getUri());
    verifyProfilePageUrl();
    verifyUsername();
  }
}