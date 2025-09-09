package interfaces.ui.steps;

import interfaces.api.authorization.controller.UserAuthorizationController;
import interfaces.api.registration.controller.UserRegistrationController;
import interfaces.ui.pages.privateArea.ProfilePage;
import io.qameta.allure.Step;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.FAVICON_URL;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.PROFILE_PAGE_URL;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
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

  @Step("[UI] Verify [Profile] page url")
  private static void verifyProfilePageUrl() {
    profilePage.verifyPageUrl(getApplicationConfigValue(PROFILE_PAGE_URL));
  }

  @Step("[UI] Verify username")
  private static void verifyUsername() {
    profilePage.verifyUsername(UI.getContextType());
  }

  @Step("[UI] Verify [Profile] page is opened")
  public static void verifyProfilePageIsOpened() {
    verifyProfilePageUrl();
    verifyUsername();
  }

  @Step("[UI] Open domain resource")
  public static void openDomainResource() {
    profilePage.openPage(getApplicationConfigValue(FAVICON_URL));
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

  @Step("[UI] Set auth user cookies and open [Profile] page")
  public static void setAuthUserCookiesAndOpenProfilePage() {
    profilePage.setAuthUserCookiesAndOpenProfilePage(getApplicationConfigValue(PROFILE_PAGE_URL));
    verifyProfilePageIsOpened();
  }

  @Step("[UI] Click 'Logout' button")
  public static void logoutButtonClick() {
    profilePage.logoutButtonClick();
  }
}