package interfaces.api.tests;

import core.listener.retry.RetryExtension;
import interfaces.api.tests.baseTest.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static core.owners.Owners.VLADIMIR_MININ;
import static docs.testDescriptions.TestDescriptions.PA_API_07;
import static interfaces.api.user.steps.UserSteps.deleteUser;
import static interfaces.api.user.steps.UserSteps.login;
import static interfaces.api.user.steps.UserSteps.registration;

@ExtendWith(RetryExtension.class)
public class DeleteUserTest extends ApiBaseTest {

  @BeforeEach
  @Step("[API] Authorize new user")
  public void authorizeNewUser() {
    registration();
    login();
  }

  @Test
  @Description(PA_API_07)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void deleteUserTest() {
    deleteUser();
  }
}