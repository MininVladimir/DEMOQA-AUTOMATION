package interfaces.ui.tests;

import core.listener.retry.RetryExtension;
import interfaces.ui.tests.baseTest.UiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static core.owners.Owners.VLADIMIR_MININ;
import static docs.testDescriptions.TestDescriptions.PA_UI_11;
import static interfaces.api.bookStore.steps.BookStoreSteps.addBookCollection;
import static interfaces.api.user.steps.UserSteps.login;
import static interfaces.api.user.steps.UserSteps.registration;
import static interfaces.ui.steps.ProfilePageSteps.openDomainResource;
import static interfaces.ui.steps.ProfilePageSteps.setAuthUserCookiesAndOpenProfilePage;
import static interfaces.ui.steps.ProfilePageSteps.verifyNonEmptyRowCountEqualsSizeOfUserBookCollection;
import static interfaces.ui.steps.ProfilePageSteps.verifyTableData;

@ExtendWith(RetryExtension.class)
public class AddBooksTest extends UiBaseTest {

  @BeforeEach
  @Step("[API] Add book collection by new registered user")
  public void addBookCollectionByNewRegisteredUser() {
    openDomainResource();
    registration();
    login();
    addBookCollection();
  }

  @Test
  @Description(PA_UI_11)
  @Owner(VLADIMIR_MININ)
  @Severity(SeverityLevel.CRITICAL)
  public void addBooksTest() {
    setAuthUserCookiesAndOpenProfilePage();
    verifyNonEmptyRowCountEqualsSizeOfUserBookCollection();
    verifyTableData();
  }
}