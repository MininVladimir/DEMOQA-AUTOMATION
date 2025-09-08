package interfaces.api.authorization.controller;

import interfaces.api.authorization.dto.authUserToken.GenerateAuthUserTokenRequest;
import interfaces.api.authorization.dto.authUserToken.GenerateAuthUserTokenResponse;
import interfaces.api.authorization.dto.authorization.UserAuthorizationResponse;
import interfaces.api.authorization.dto.sendCredentials.SendUserCredentialsRequest;
import interfaces.api.authorization.dto.sendCredentials.SendUserCredentialsResponse;
import core.context.service.IContextService;
import org.junit.jupiter.api.Assertions;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.ConfigKey.GENERATE_TOKEN_SERVICE;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.ConfigKey.SEND_CREDENTIAL_SERVICE;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.ConfigKey.USER_LOGIN_SERVICE;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static interfaces.api.specifications.Specifications.removeSpecifications;
import static interfaces.api.specifications.Specifications.installSpecification;
import static interfaces.api.specifications.Specifications.requestSpecification;
import static interfaces.api.specifications.Specifications.responseSpecification;
import static enums.HeaderType.AUTHORIZATION;
import static enums.ResultType.USER_AUTHORIZED_SUCCESSFULLY;
import static enums.StatusCodeType.OK;
import static enums.StatusType.SUCCESS;
import static enums.TokenType.BEARER;
import static io.restassured.RestAssured.given;

public class UserAuthorizationController implements IContextService {

  public void generateToken(String contextType) {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    GenerateAuthUserTokenRequest generateAuthUserTokenRequest = new GenerateAuthUserTokenRequest(IContextService.getUsernameFromContext(contextType), IContextService.getPasswordFromContext(contextType));
    GenerateAuthUserTokenResponse generateAuthUserTokenResponse = given()
      .body(generateAuthUserTokenRequest)
      .when()
      .post(getApplicationConfigValue(GENERATE_TOKEN_SERVICE))
      .then()
      .extract().response().as(GenerateAuthUserTokenResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertNotNull(generateAuthUserTokenResponse.token()),
      () -> Assertions.assertNotNull(generateAuthUserTokenResponse.expiresDate()),
      () -> Assertions.assertEquals(SUCCESS.getStatus(), generateAuthUserTokenResponse.status()),
      () -> Assertions.assertEquals(USER_AUTHORIZED_SUCCESSFULLY.getResult(), generateAuthUserTokenResponse.result())
    );

    IContextService.setTokenToContext(contextType, generateAuthUserTokenResponse.token());
  }

  public void sendCredentials(String contextType) {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    SendUserCredentialsRequest sendUserCredentialsRequest = new SendUserCredentialsRequest(IContextService.getUsernameFromContext(contextType), IContextService.getPasswordFromContext(contextType));
    SendUserCredentialsResponse sendUserCredentialsResponse = given()
      .body(sendUserCredentialsRequest)
      .when()
      .post(getApplicationConfigValue(SEND_CREDENTIAL_SERVICE))
      .then()
      .extract().response().as(SendUserCredentialsResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertEquals(IContextService.getUserIdFromContext(contextType), sendUserCredentialsResponse.userId()),
      () -> Assertions.assertEquals(IContextService.getUsernameFromContext(contextType), sendUserCredentialsResponse.username()),
      () -> Assertions.assertEquals(IContextService.getPasswordFromContext(contextType), sendUserCredentialsResponse.password()),
      () -> Assertions.assertEquals(IContextService.getTokenFromContext(contextType), sendUserCredentialsResponse.token()),
      () -> Assertions.assertNotNull(sendUserCredentialsResponse.expiresDate()),
      () -> Assertions.assertNotNull(sendUserCredentialsResponse.createdDate()),
      () -> Assertions.assertNotNull(sendUserCredentialsResponse.isActive())
    );

    IContextService.setExpiresDateToContext(contextType, sendUserCredentialsResponse.expiresDate());
  }

  public void authorization(String contextType) {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    UserAuthorizationResponse userAuthorizationResponse = given()
      .header(AUTHORIZATION.getHeader(), BEARER.getToken() + IContextService.getTokenFromContext(contextType))
      .when()
      .get(getApplicationConfigValue(USER_LOGIN_SERVICE) + IContextService.getUserIdFromContext(contextType))
      .then()
      .extract().response().as(UserAuthorizationResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertEquals(IContextService.getUserIdFromContext(contextType), userAuthorizationResponse.userId()),
      () -> Assertions.assertEquals(IContextService.getUsernameFromContext(contextType), userAuthorizationResponse.username()),
      () -> Assertions.assertTrue(userAuthorizationResponse.books().isEmpty())
    );
  }
}