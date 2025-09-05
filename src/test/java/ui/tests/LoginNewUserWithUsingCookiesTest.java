package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.tests.baseTest.UiBaseTest;

import static core.owners.Owners.VLADIMIR_MININ;
import static docs.tetsDescriptions.TestDescriptions.PA_UI_03;
import static ui.steps.ProfilePageSteps.login;
import static ui.steps.ProfilePageSteps.openDomainResource;
import static ui.steps.ProfilePageSteps.registration;
import static ui.steps.ProfilePageSteps.setAuthUserCookiesAndOpenUserProfilePage;

public class LoginNewUserWithUsingCookiesTest extends UiBaseTest {

  @BeforeEach
  @Step("Open domain resource and login new registered user with api")
  public void openDomainResourceAndLoginNewRegisteredUserWithApi() {
    openDomainResource();
    registration();
    login();
  }

  @Test
  @Description(PA_UI_03)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void loginNewUserWithUsingCookiesTest() {
    setAuthUserCookiesAndOpenUserProfilePage();
  }

  @AfterEach
  @Step("Clear temporary data")
  public void clearTemporaryData() {
    clearLocalStorage();
    removeContext();
  }
}