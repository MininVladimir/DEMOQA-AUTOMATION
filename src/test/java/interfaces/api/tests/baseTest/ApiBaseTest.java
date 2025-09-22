package interfaces.api.tests.baseTest;


import core.context.ContextHolder;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;

public class ApiBaseTest {

  @AfterEach
  @Step("Remove context")
  public void removeContext() {
    ContextHolder.removeContext();
  }
}