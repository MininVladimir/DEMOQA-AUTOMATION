package interfaces.api.registration.controller;

import interfaces.api.registration.dto.UserRegistrationRequest;
import interfaces.api.registration.dto.UserRegistrationResponse;
import core.context.service.IContextService;
import org.junit.jupiter.api.Assertions;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.USER_REGISTRATION_SERVICE_ENDPOINT;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static enums.StatusCodeType.CREATED;
import static interfaces.api.specifications.Specifications.installSpecification;
import static interfaces.api.specifications.Specifications.removeSpecifications;
import static interfaces.api.specifications.Specifications.requestSpecification;
import static interfaces.api.specifications.Specifications.responseSpecification;
import static io.restassured.RestAssured.given;

public class UserRegistrationController implements IContextService {

  public void registration(String contextType) {
    IContextService.setUserUsernameToContext(contextType);
    IContextService.setPasswordToContext(contextType);

    installSpecification(
      requestSpecification(),
      responseSpecification(CREATED.getStatusCode())
    );

    UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest(IContextService.getUsernameFromContext(contextType), IContextService.getPasswordFromContext(contextType));
    UserRegistrationResponse userRegistrationResponse = given()
      .body(userRegistrationRequest)
      .when()
      .post(getApplicationConfigValue(USER_REGISTRATION_SERVICE_ENDPOINT))
      .then()
      .extract().response().as(UserRegistrationResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertNotNull(userRegistrationResponse.userId()),
      () -> Assertions.assertEquals(userRegistrationRequest.username(), userRegistrationResponse.username()),
      () -> Assertions.assertTrue(userRegistrationResponse.books().isEmpty())
    );

    IContextService.setUserIdToContext(contextType, userRegistrationResponse.userId());
  }
}