package core.utils.table;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class TableUtils {

  public static String getCellValueByColumnAndRow(By headerCellLocator, By nonEmptyRowLocator, By cellLocator, String columnName, int rowIndex) {
    ElementsCollection headers = $$(headerCellLocator);

    int columnIndex = headers.stream()
      .map(SelenideElement::getText)
      .toList()
      .indexOf(columnName);

    ElementsCollection rows = $$(nonEmptyRowLocator);
    ElementsCollection cells = rows.get(rowIndex).$$(cellLocator);
    return cells.get(columnIndex).getText();
  }

  public static int getNonEmptyRowCount(By nonEmptyRowLocator) {
    return $$(nonEmptyRowLocator).size();
  }
}