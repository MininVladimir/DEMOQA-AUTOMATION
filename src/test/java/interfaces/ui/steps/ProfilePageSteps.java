package interfaces.ui.steps;

import interfaces.ui.pages.privateArea.ProfilePage;
import io.qameta.allure.Step;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.FAVICON_URL;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.PROFILE_PAGE_URL;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static enums.ResultType.USER_DELETED;

public class ProfilePageSteps {
  static ProfilePage profilePage = new ProfilePage();

  @Step("[UI] Verify [Profile] page url")
  private static void verifyProfilePageUrl() {
    profilePage.verifyPageUrl(getApplicationConfigValue(PROFILE_PAGE_URL));
  }

  @Step("[UI] Verify username")
  private static void verifyUsername() {
    profilePage.verifyUsername();
  }

  @Step("[UI] Click 'Delete Account' button")
  private static void deleteAccountButtonClick() {
    profilePage.deleteAccountButtonClick();
  }

  @Step("[UI] Click 'OK' button in modal window")
  private static void deleteUserConfirmation() {
    profilePage.deleteUserConfirmation();
  }

  @Step("[UI] Verify alert message and click 'OK' button")
  private static void verifyAlertMessageAndAccept() {
    profilePage.verifyAlertMessage(USER_DELETED.getResult());
    profilePage.acceptAlert();
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

  @Step("[UI] Set auth user cookies and open [Profile] page")
  public static void setAuthUserCookiesAndOpenProfilePage() {
    profilePage.setAuthUserCookiesAndOpenProfilePage(getApplicationConfigValue(PROFILE_PAGE_URL));
    verifyProfilePageIsOpened();
  }

  @Step("[UI] Click 'Logout' button")
  public static void logoutButtonClick() {
    profilePage.logoutButtonClick();
  }

  @Step("[UI] Delete user")
  public static void deleteUser() {
    deleteAccountButtonClick();
    deleteUserConfirmation();
    verifyAlertMessageAndAccept();
  }

  @Step("[UI] Verify non-empty row count equals size of user book collection")
  public static void verifyNonEmptyRowCountEqualsSizeOfUserBookCollection() {
    profilePage.verifyNonEmptyRowCountEqualsSizeOfUserBookCollection();
  }

  @Step("[UI] Verify table data")
  public static void verifyTableData() {
    profilePage.verifyTableData();
  }
}