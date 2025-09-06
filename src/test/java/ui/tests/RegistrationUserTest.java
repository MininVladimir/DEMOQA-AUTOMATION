package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ui.tests.baseTest.UiBaseTest;
import static core.owners.Owners.VLADIMIR_MININ;
import static docs.tetsDescriptions.TestDescriptions.REG_UI_04;
import static ui.steps.RegistrationPageSteps.registration;

public class RegistrationUserTest extends UiBaseTest {

  @Test
  @Flaky
  @Description(REG_UI_04)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void registrationUserTest() {
   registration();
  }

  @AfterEach
  @Step("Clear temporary data")
  public void clearTemporaryData() {
    clearLocalStorage();
    removeContext();
  }
}