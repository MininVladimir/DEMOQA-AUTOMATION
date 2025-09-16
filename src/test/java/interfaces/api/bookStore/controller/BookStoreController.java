package interfaces.api.bookStore.controller;

import core.context.service.IContextService;
import core.listener.restAssuredListener.IRestAssuredListener;
import interfaces.api.bookStore.dto.bookStoreList.GetBookStoreListResponse;
import interfaces.api.bookStore.dto.userList.AddBookRequest;
import interfaces.api.bookStore.service.IBookStoreController;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.BOOK_STORE_SERVICE_ENDPOINT;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static enums.HeaderType.AUTHORIZATION;
import static enums.StatusCodeType.CREATED;
import static enums.StatusCodeType.OK;
import static enums.TokenType.BEARER;
import static interfaces.api.specifications.Specifications.installSpecification;
import static interfaces.api.specifications.Specifications.removeSpecifications;
import static interfaces.api.specifications.Specifications.requestSpecification;
import static interfaces.api.specifications.Specifications.responseSpecification;
import static io.restassured.RestAssured.given;

public class BookStoreController implements IContextService, IRestAssuredListener, IBookStoreController {

  public List<GetBookStoreListResponse> getBookList() {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    List<GetBookStoreListResponse> bookList = given()
      .filter(allureFilter)
      .when()
      .get(getApplicationConfigValue(BOOK_STORE_SERVICE_ENDPOINT))
      .then()
      .extract().response().jsonPath().getList("books", GetBookStoreListResponse.class);

    removeSpecifications();

    Assertions.assertFalse(bookList.isEmpty());
    return bookList;
  }

  public void addBook(String contextType, List<GetBookStoreListResponse> bookList) {
    installSpecification(
      requestSpecification(),
      responseSpecification(CREATED.getStatusCode())
    );

    AddBookRequest.CollectionOfIsbns collectionOfIsbns = IBookStoreController.getRandomBook(bookList);
    IContextService.setIsbnToContext(contextType, collectionOfIsbns.isbn());

    AddBookRequest addBookRequest = new AddBookRequest(IContextService.getUserIdFromContext(contextType), List.of(collectionOfIsbns));
    String isbnOfAddedBook = given()
      .filter(allureFilter)
      .header(AUTHORIZATION.getHeader(), BEARER.getToken() + IContextService.getTokenFromContext(contextType))
      .body(addBookRequest)
      .when()
      .post(getApplicationConfigValue(BOOK_STORE_SERVICE_ENDPOINT))
      .then()
      .extract().response().jsonPath().getString("books[0].isbn");

    removeSpecifications();

    Assertions.assertEquals(IContextService.getIsbnFromContext(contextType), isbnOfAddedBook);
  }
}