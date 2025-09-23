package interfaces.ui.pages.privateArea;

import com.codeborne.selenide.ElementsCollection;
import core.context.ContextHolder;
import core.context.IContext;
import core.utils.cookie.CookieUtils;
import core.utils.table.TableUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import interfaces.ui.pages.basePage.BasePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage extends BasePage {
  private final By usernameValueLocator = By.id("userName-value");
  private final By logoutButton = By.xpath("//button[text()='Log out']");
  private final By deleteAccountButton = By.xpath("//button[text()='Delete Account']");
  private final By submitOfDeleteUserButton = By.id("closeSmallModal-ok");
  private final By headerCellLocator = By.xpath(".//div[@role='columnheader']");
  private final By cellLocator = By.xpath(".//div[@class='rt-td']");
  private final By nonEmptyRowLocator = By.xpath("//div[@role='row'][div[@class='rt-td'][normalize-space(text())]]");
  private Map<String, Integer> columnIndexMap;
  private ElementsCollection rows;

  private void initTableData() {
    ElementsCollection headers = $$(headerCellLocator);
    columnIndexMap = TableUtils.getColumnIndexMap(headers);
  }

  private String getCellValueByColumnAndRow(String columnName, int rowIndex) {
    return TableUtils.getCellValueByColumnAndRow(rows, columnIndexMap, cellLocator, columnName, rowIndex);
  }

  private int getNonEmptyRowCount() {
    return TableUtils.getNonEmptyRowCount(rows);
  }

  public void setAuthUserCookiesAndOpenProfilePage(String url) {
    CookieUtils.setAuthUserCookiesAndOpenPrivateAreaPage(url);
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

  public void verifyNonEmptyRowCountEqualsSizeOfUserBookCollection() {
    rows = $$(nonEmptyRowLocator);
    Assertions.assertEquals(ContextHolder.getContext().getBookCollection().size(), getNonEmptyRowCount());
  }

  public void verifyTableData() {
    initTableData();
    for(int i = 0; i < ContextHolder.getContext().getBookCollection().size(); i++) {
      Assertions.assertEquals(ContextHolder.getContext().getBookCollection().get(i).get("title"), getCellValueByColumnAndRow("Title", i));
      Assertions.assertEquals(ContextHolder.getContext().getBookCollection().get(i).get("author"), getCellValueByColumnAndRow("Author", i));
      Assertions.assertEquals(ContextHolder.getContext().getBookCollection().get(i).get("publisher"), getCellValueByColumnAndRow("Publisher", i));
    }
  }
}