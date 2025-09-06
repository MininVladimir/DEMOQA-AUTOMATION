package interfaces.api.tests;

import core.listener.retry.RetryExtension;
import interfaces.api.tests.baseTest.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static interfaces.api.authorization.steps.UserAuthorizationSteps.login;
import static interfaces.api.registration.steps.UserRegistrationSteps.registration;
import static core.owners.Owners.VLADIMIR_MININ;
import static docs.tetsDescriptions.TestDescriptions.PA_API_02;

@ExtendWith(RetryExtension.class)
public class LoginNewUserTest extends ApiBaseTest {

  @BeforeEach
  public void registerNewUser() {
    registration();
  }

  @Test
  @Description(PA_API_02)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void loginNewUserTest() {
    login();
  }
}