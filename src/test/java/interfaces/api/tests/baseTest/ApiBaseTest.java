package interfaces.api.tests.baseTest;

import core.context.api.ApiContextHolder;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;

public class ApiBaseTest {

  @AfterEach
  @Step("Remove context")
  public void removeContext() {
    ApiContextHolder.removeContext();
  }
}