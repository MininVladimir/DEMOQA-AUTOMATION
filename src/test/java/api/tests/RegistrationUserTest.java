package api.tests;

import api.tests.baseTest.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

import static api.registration.steps.UserRegistrationSteps.registration;
import static core.owners.Owners.VLADIMIR_MININ;
import static docs.tetsDescriptions.TestDescriptions.REG_API_01;

public class RegistrationUserTest extends ApiBaseTest {

  @Test
  @Description(REG_API_01)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void registrationUserTest() {
    registration();
  }
}