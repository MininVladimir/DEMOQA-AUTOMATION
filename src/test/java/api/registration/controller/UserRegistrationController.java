package api.registration.controller;

import api.registration.dto.UserRegistrationRequest;
import api.registration.dto.UserRegistrationResponse;
import core.context.service.IContextService;
import org.junit.jupiter.api.Assertions;

import static api.specifications.Specifications.removeSpecifications;
import static api.specifications.Specifications.installSpecification;
import static api.specifications.Specifications.requestSpecification;
import static api.specifications.Specifications.responseSpecification;
import static enums.EndpointType.USER_REGISTRATION;
import static enums.StatusCodeType.CREATED;
import static enums.UriPageType.BASE_URI;
import static io.restassured.RestAssured.given;

public class UserRegistrationController implements IContextService {

  public void registration(String contextType) {
    setUserUsernameToContext(contextType);
    setPasswordToContext(contextType);

    installSpecification(
      requestSpecification(BASE_URI.getUri()),
      responseSpecification(CREATED.getStatusCode())
    );

    UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest(getUsernameFromContext(contextType), getPasswordFromContext(contextType));
    UserRegistrationResponse userRegistrationResponse = given()
      .body(userRegistrationRequest)
      .when()
      .post(USER_REGISTRATION.getEndpoint())
      .then()
      .extract().response().as(UserRegistrationResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertNotNull(userRegistrationResponse.userId()),
      () -> Assertions.assertEquals(userRegistrationRequest.username(), userRegistrationResponse.username()),
      () -> Assertions.assertTrue(userRegistrationResponse.books().isEmpty())
    );

    setUserIdToContext(contextType, userRegistrationResponse.userId());
  }
}