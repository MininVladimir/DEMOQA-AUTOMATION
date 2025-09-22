package core.utils.table;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class TableUtils {

  public static String getCellValueByColumnAndRow(
    ElementsCollection rows,
    Map<String, Integer> columnIndexMap,
    By cellLocator,
    String columnName,
    int rowIndex) {
    int columnIndex = columnIndexMap.getOrDefault(columnName, -1);
    if (columnIndex == -1) {
      throw new IllegalArgumentException("Column '" + columnName + "' not found");
    }

    ElementsCollection cells = rows.get(rowIndex).$$(cellLocator);
    return cells.get(columnIndex).getText();
  }

  public static int getNonEmptyRowCount(ElementsCollection rows) {
    return rows.size();
  }

  public static Map<String, Integer> getColumnIndexMap(ElementsCollection headers) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < headers.size(); i++) {
      map.put(headers.get(i).getText(), i);
    }
    return map;
  }
}