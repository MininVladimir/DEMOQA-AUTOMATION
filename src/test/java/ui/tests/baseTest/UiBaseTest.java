package ui.tests.baseTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class UiBaseTest implements IUiBaseTest {

  @BeforeAll
  public static void setup() throws Exception {
    IUiBaseTest.setupDriver();
  }

  @AfterAll
  public static void tearDown() {
    IUiBaseTest.closeDriver();
  }
}