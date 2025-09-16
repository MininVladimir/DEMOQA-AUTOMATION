package interfaces.api.tests;

import core.listener.retry.RetryExtension;
import interfaces.api.tests.baseTest.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static core.owners.Owners.VLADIMIR_MININ;
import static docs.testDescriptions.TestDescriptions.BOOKS_API_10;
import static interfaces.api.bookStore.steps.BookStoreSteps.addBook;
import static interfaces.api.user.steps.UserSteps.login;
import static interfaces.api.user.steps.UserSteps.registration;

@ExtendWith(RetryExtension.class)
public class AddBookToUserBinTest extends ApiBaseTest {

  @BeforeEach
  public void loginNewUser() {
    registration();
    login();
  }

  @Test
  @Description(BOOKS_API_10)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void addBookTest() {
    addBook();
  }
}