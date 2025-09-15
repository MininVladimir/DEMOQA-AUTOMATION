package interfaces.api.bookStore.controller;

import core.context.service.IContextService;
import core.listener.restAssuredListener.IRestAssuredListener;
import interfaces.api.bookStore.dto.GetBookListResponse;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.BOOK_STORE_SERVICE_ENDPOINT;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static enums.StatusCodeType.OK;
import static interfaces.api.specifications.Specifications.installSpecification;
import static interfaces.api.specifications.Specifications.removeSpecifications;
import static interfaces.api.specifications.Specifications.requestSpecification;
import static interfaces.api.specifications.Specifications.responseSpecification;
import static io.restassured.RestAssured.given;

public class BookStoreController implements IContextService, IRestAssuredListener {

  public List<GetBookListResponse> getBookList() {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    List <GetBookListResponse> bookList = given()
      .filter(allureFilter)
      .when()
      .get(getApplicationConfigValue(BOOK_STORE_SERVICE_ENDPOINT))
      .then()
      .extract().response().jsonPath().getList("books", GetBookListResponse.class);

    removeSpecifications();

    Assertions.assertNotNull(bookList);
    return bookList;
  }
}