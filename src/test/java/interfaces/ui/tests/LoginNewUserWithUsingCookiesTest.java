package interfaces.ui.tests;

import core.listener.retry.RetryExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import interfaces.ui.tests.baseTest.UiBaseTest;
import org.junit.jupiter.api.extension.ExtendWith;

import static core.owners.Owners.VLADIMIR_MININ;
import static docs.testDescriptions.TestDescriptions.PA_UI_03;
import static interfaces.api.user.steps.UserSteps.login;
import static interfaces.api.user.steps.UserSteps.registration;
import static interfaces.ui.steps.ProfilePageSteps.openDomainResource;
import static interfaces.ui.steps.ProfilePageSteps.setAuthUserCookiesAndOpenProfilePage;

@ExtendWith(RetryExtension.class)
public class LoginNewUserWithUsingCookiesTest extends UiBaseTest {

  @BeforeEach
  @Step("[API] Open domain resource and login new registered user")
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
    setAuthUserCookiesAndOpenProfilePage();
  }
}