package interfaces.ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import core.listener.retry.RetryExtension;
import interfaces.ui.tests.baseTest.UiBaseTest;

import static core.owners.Owners.VLADIMIR_MININ;
import static docs.testDescriptions.TestDescriptions.REG_UI_04;
import static interfaces.ui.steps.RegistrationPageSteps.registration;

@ExtendWith(RetryExtension.class)
public class RegistrationUserTest extends UiBaseTest {

  @Test
  @Flaky
  @Description(REG_UI_04)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void registrationUserTest() {
    registration();
  }
}