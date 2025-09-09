package interfaces.ui.tests.baseTest;

import core.listener.screenshotListener.IScreenshotListener;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class UiBaseTest implements IUiBaseTest, IScreenshotListener {

  @BeforeAll
  public static void setup() throws Exception {
    IUiBaseTest.setupDriver();
    IScreenshotListener.addScreenshotListener();
  }

  @AfterEach
  @Step("Clear temporary data")
  public void clearTemporaryData() {
    clearLocalStorage();
    removeContext();
  }

  @AfterAll
  public static void tearDown() {
    IScreenshotListener.removeScreenshotListener();
    IUiBaseTest.closeDriver();
  }
}