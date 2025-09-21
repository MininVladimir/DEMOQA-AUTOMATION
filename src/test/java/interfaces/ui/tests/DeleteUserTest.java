package interfaces.ui.tests;

import core.listener.retry.RetryExtension;
import interfaces.ui.tests.baseTest.UiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static core.owners.Owners.VLADIMIR_MININ;
import static docs.testDescriptions.TestDescriptions.PA_UI_08;
import static interfaces.api.user.steps.UserSteps.login;
import static interfaces.api.user.steps.UserSteps.registration;
import static interfaces.ui.steps.LoginPageSteps.verifyLoginPageUrl;
import static interfaces.ui.steps.ProfilePageSteps.deleteUser;
import static interfaces.ui.steps.ProfilePageSteps.openDomainResource;
import static interfaces.ui.steps.ProfilePageSteps.setAuthUserCookiesAndOpenProfilePage;

@ExtendWith(RetryExtension.class)
public class DeleteUserTest extends UiBaseTest {

  @BeforeEach
  @Step("[UI] Open [Profile] page by new registered user")
  public void OpenProfilePageByNewRegisteredUser() {
    openDomainResource();
    registration();
    login();
    setAuthUserCookiesAndOpenProfilePage();
  }

  @Test
  @Description(PA_UI_08)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void deleteUserTest() {
    deleteUser();
    verifyLoginPageUrl();
  }
}