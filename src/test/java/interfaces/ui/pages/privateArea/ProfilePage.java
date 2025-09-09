package interfaces.ui.pages.privateArea;

import core.context.service.IContextService;
import org.openqa.selenium.By;
import interfaces.ui.pages.basePage.BasePage;

public class ProfilePage extends BasePage {
  private final By usernameValueLocator = By.id("userName-value");
  private final By logoutButton = By.xpath("//button[text()='Log out']");

  public void setAuthUserCookiesAndOpenProfilePage(String url) {
    setAuthUserCookiesAndOpenPrivateAreaPage(url);
  }

  public void verifyUsername(String contextType) {
    verifyTextOfElement(usernameValueLocator, IContextService.getUsernameFromContext(contextType));
  }

  public void logoutButtonClick() {
    elementClick(logoutButton);
  }
}