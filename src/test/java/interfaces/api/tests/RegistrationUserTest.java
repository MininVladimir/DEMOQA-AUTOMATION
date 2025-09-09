package interfaces.api.tests;

import core.listener.retry.RetryExtension;
import interfaces.api.tests.baseTest.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static core.owners.Owners.VLADIMIR_MININ;
import static docs.tetsDescriptions.TestDescriptions.REG_API_01;
import static interfaces.api.user.steps.UserSteps.registration;

@ExtendWith(RetryExtension.class)
public class RegistrationUserTest extends ApiBaseTest {

  @Test
  @Description(REG_API_01)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void registrationUserTest() {
    registration();
  }
}