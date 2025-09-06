package ui.tests.baseTest;

import core.listener.screenshotListener.IScreenshotListener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class UiBaseTest implements IUiBaseTest, IScreenshotListener {

  @BeforeAll
  public static void setup() throws Exception {
    IUiBaseTest.setupDriver();
    IScreenshotListener.addScreenshotListener();
  }

  @AfterAll
  public static void tearDown() {
    IScreenshotListener.removeScreenshotListener();
    IUiBaseTest.closeDriver();
  }
}