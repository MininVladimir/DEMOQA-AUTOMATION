package interfaces.ui.pages.privateArea;

import core.context.service.IContextService;
import org.openqa.selenium.By;
import interfaces.ui.pages.basePage.BasePage;

public class ProfilePage extends BasePage {
  private final By usernameValueLocator = By.id("userName-value");

  public void setAuthUserCookiesAndOpenUserProfilePage(String url) {
    setAuthUserCookiesAndOpenPrivateAreaPage(url);
  }

  public void verifyUsername(String contextType) {
    verifyTextOfElement(usernameValueLocator, IContextService.getUsernameFromContext(contextType));
  }
}