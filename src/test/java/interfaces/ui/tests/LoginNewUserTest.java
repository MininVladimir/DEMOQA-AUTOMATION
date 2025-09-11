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
import static docs.testDescriptions.TestDescriptions.PA_UI_05;
import static interfaces.ui.steps.LoginPageSteps.login;
import static interfaces.ui.steps.LoginPageSteps.openLoginPage;
import static interfaces.ui.steps.LoginPageSteps.registration;
import static interfaces.ui.steps.ProfilePageSteps.verifyProfilePageIsOpened;

@ExtendWith(RetryExtension.class)
public class LoginNewUserTest extends UiBaseTest {

  @BeforeEach
  @Step("Register new user with api and open login page")
  public void registerNewUserWithApiAndOpenLoginPage() {
    registration();
    openLoginPage();
  }

  @Test
  @Description(PA_UI_05)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void loginNewUserTest() {
    login();
    verifyProfilePageIsOpened();
  }
}