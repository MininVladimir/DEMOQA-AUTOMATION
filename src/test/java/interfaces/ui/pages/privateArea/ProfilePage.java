package interfaces.ui.pages.privateArea;

import core.context.IContext;
import org.openqa.selenium.By;
import interfaces.ui.pages.basePage.BasePage;

public class ProfilePage extends BasePage {
  private final By usernameValueLocator = By.id("userName-value");
  private final By logoutButton = By.xpath("//button[text()='Log out']");
  private final By deleteAccountButton = By.xpath("//button[text()='Delete Account']");
  private final By submitOfDeleteUserButton = By.id("closeSmallModal-ok");

  public void setAuthUserCookiesAndOpenProfilePage(String url) {
    setAuthUserCookiesAndOpenPrivateAreaPage(url);
  }

  public void verifyUsername() {
    verifyTextOfElement(usernameValueLocator, IContext.getUsernameFromContext());
  }

  public void logoutButtonClick() {
    elementClick(logoutButton);
  }

  public void deleteAccountButtonClick() {
    elementClick(deleteAccountButton);
  }

  public void deleteUserConfirmation() {
    elementClick(submitOfDeleteUserButton);
  }
}