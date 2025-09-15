package interfaces.api.tests;

import core.listener.retry.RetryExtension;
import interfaces.api.tests.baseTest.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static core.owners.Owners.VLADIMIR_MININ;
import static docs.testDescriptions.TestDescriptions.BOOKS_API_09;
import static interfaces.api.bookStore.steps.BookStoreSteps.getBookList;

@ExtendWith(RetryExtension.class)
public class GetBookListTest extends ApiBaseTest {

  @Test
  @Description(BOOKS_API_09)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void getBookListTest() {
    getBookList();
  }
}