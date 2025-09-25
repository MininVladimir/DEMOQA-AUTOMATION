package interfaces.api.bookStore.controller;

import core.context.IContext;
import core.listener.restAssuredListener.IRestAssuredListener;
import interfaces.api.bookStore.dto.deleteBook.DeleteBookRequest;
import interfaces.api.bookStore.dto.getBookStoreList.GetBookStoreListResponse;
import interfaces.api.bookStore.dto.addBooks.AddBookCollectionRequest;
import interfaces.api.bookStore.dto.addBooks.AddBookCollectionResponse;
import interfaces.api.bookStore.dto.verifyUserBookCollection.VerifyUserBookCollectionResponse;
import interfaces.api.bookStore.service.IBookStoreController;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.BOOK_STORE_SERVICE;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.DELETE_BOOK_COLLECTION_ENDPOINT;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.DELETE_BOOK_SERVICE;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.USER_SERVICE;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static enums.HeaderType.AUTHORIZATION;
import static enums.StatusCodeType.CREATED;
import static enums.StatusCodeType.NO_CONTENT;
import static enums.StatusCodeType.OK;
import static enums.TokenType.BEARER;
import static interfaces.api.specifications.Specifications.installSpecification;
import static interfaces.api.specifications.Specifications.removeSpecifications;
import static interfaces.api.specifications.Specifications.requestSpecification;
import static interfaces.api.specifications.Specifications.responseSpecification;
import static io.restassured.RestAssured.given;

public class BookStoreController implements IContext, IRestAssuredListener, IBookStoreController {

  public List<GetBookStoreListResponse> getBookList() {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    List<GetBookStoreListResponse> bookList = given()
      .filter(allureFilter)
      .when()
      .get(getApplicationConfigValue(BOOK_STORE_SERVICE))
      .then()
      .extract().response().jsonPath().getList("books", GetBookStoreListResponse.class);

    removeSpecifications();

    Assertions.assertFalse(bookList.isEmpty());
    return bookList;
  }

  public void addBookCollection(List<GetBookStoreListResponse> bookList, int bookCount) {
    installSpecification(
      requestSpecification(),
      responseSpecification(CREATED.getStatusCode())
    );

    List<HashMap<String, Object>> generatedBookCollection = IBookStoreController.getBookCollection(bookList, bookCount);
    IContext.setBookCollectionToContext(generatedBookCollection);

    AddBookCollectionRequest addBookCollectionRequest = new AddBookCollectionRequest(IContext.getUserIdFromContext(), generatedBookCollection);
    List<HashMap<String, Object>> userBookCollection = given()
      .filter(allureFilter)
      .header(AUTHORIZATION.getHeader(), BEARER.getToken() + IContext.getTokenFromContext())
      .body(addBookCollectionRequest)
      .when()
      .post(getApplicationConfigValue(BOOK_STORE_SERVICE))
      .then()
      .extract().response().as(AddBookCollectionResponse.class).userBookCollection();

    removeSpecifications();

    Assertions.assertEquals(IContext.getBookCollectionFromContext(), userBookCollection);
  }

  public void deleteBookCollection() {
    installSpecification(
      requestSpecification(),
      responseSpecification(NO_CONTENT.getStatusCode())
    );

    given()
      .filter(allureFilter)
      .header(AUTHORIZATION.getHeader(), BEARER.getToken() + IContext.getTokenFromContext())
      .when()
      .delete(getApplicationConfigValue(DELETE_BOOK_COLLECTION_ENDPOINT) + IContext.getUserIdFromContext());

    removeSpecifications();

    IContext.getBookCollectionFromContext().clear();
  }

  public void deleteBook() {
    installSpecification(
      requestSpecification(),
      responseSpecification(NO_CONTENT.getStatusCode())
    );

    String isbnOfDeletedBook = IBookStoreController.getRandomIsbnOfBookFromBookCollection();
    DeleteBookRequest deleteBookRequest = new DeleteBookRequest(isbnOfDeletedBook, IContext.getUserIdFromContext());
    given()
      .filter(allureFilter)
      .header(AUTHORIZATION.getHeader(), BEARER.getToken() + IContext.getTokenFromContext())
      .body(deleteBookRequest)
      .when()
      .delete(getApplicationConfigValue(DELETE_BOOK_SERVICE));

    removeSpecifications();

    IContext.getBookCollectionFromContext().removeIf(x -> x.containsValue(isbnOfDeletedBook));
  }

  public void verifyUserBookCollection() {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    VerifyUserBookCollectionResponse verifyUserBookCollectionResponse = given()
      .filter(allureFilter)
      .header(AUTHORIZATION.getHeader(), BEARER.getToken() + IContext.getTokenFromContext())
      .when()
      .get(getApplicationConfigValue(USER_SERVICE) + IContext.getUserIdFromContext())
      .then()
      .extract().response().as(VerifyUserBookCollectionResponse.class);

    removeSpecifications();

    for (int i = 0; i < IContext.getBookCollectionFromContext().size(); i++) {
      Assertions.assertEquals(IContext.getBookCollectionFromContext().get(i).get("isbn"), verifyUserBookCollectionResponse.userBookCollection().get(i).get("isbn")
      );
    }
  }
}