package api.authorization.controller;

import api.authorization.dto.authUserToken.GenerateAuthUserTokenRequest;
import api.authorization.dto.authUserToken.GenerateAuthUserTokenResponse;
import api.authorization.dto.authorization.UserAuthorizationResponse;
import api.authorization.dto.sendCredentials.SendUserCredentialsRequest;
import api.authorization.dto.sendCredentials.SendUserCredentialsResponse;
import core.context.service.IContextService;
import org.junit.jupiter.api.Assertions;

import static api.specifications.Specifications.removeSpecifications;
import static api.specifications.Specifications.installSpecification;
import static api.specifications.Specifications.requestSpecification;
import static api.specifications.Specifications.responseSpecification;
import static enums.EndpointType.LOGIN;
import static enums.HeaderType.AUTHORIZATION;
import static enums.EndpointType.GENERATE_TOKEN;
import static enums.EndpointType.USER_LOGIN;
import static enums.ResultType.USER_AUTHORIZED_SUCCESSFULLY;
import static enums.StatusCodeType.OK;
import static enums.StatusType.SUCCESS;
import static enums.TokenType.BEARER;
import static enums.UriPageType.BASE_URI;
import static io.restassured.RestAssured.given;

public class UserAuthorizationController implements IContextService {

  public void generateToken(String contextType) {
    installSpecification(
      requestSpecification(BASE_URI.getUri()),
      responseSpecification(OK.getStatusCode())
    );

    GenerateAuthUserTokenRequest generateAuthUserTokenRequest = new GenerateAuthUserTokenRequest(getUsernameFromContext(contextType), getPasswordFromContext(contextType));
    GenerateAuthUserTokenResponse generateAuthUserTokenResponse = given()
      .body(generateAuthUserTokenRequest)
      .when()
      .post(GENERATE_TOKEN.getEndpoint())
      .then()
      .extract().response().as(GenerateAuthUserTokenResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertNotNull(generateAuthUserTokenResponse.token()),
      () -> Assertions.assertNotNull(generateAuthUserTokenResponse.expiresDate()),
      () -> Assertions.assertEquals(SUCCESS.getStatus(), generateAuthUserTokenResponse.status()),
      () -> Assertions.assertEquals(USER_AUTHORIZED_SUCCESSFULLY.getResult(), generateAuthUserTokenResponse.result())
    );

    setTokenToContext(contextType, generateAuthUserTokenResponse.token());
  }

  public void sendCredentials(String contextType) {
    installSpecification(
      requestSpecification(BASE_URI.getUri()),
      responseSpecification(OK.getStatusCode())
    );

    SendUserCredentialsRequest sendUserCredentialsRequest = new SendUserCredentialsRequest(getUsernameFromContext(contextType), getPasswordFromContext(contextType));
    SendUserCredentialsResponse sendUserCredentialsResponse = given()
      .body(sendUserCredentialsRequest)
      .when()
      .post(LOGIN.getEndpoint())
      .then()
      .extract().response().as(SendUserCredentialsResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertEquals(getUserIdFromContext(contextType), sendUserCredentialsResponse.userId()),
      () -> Assertions.assertEquals(getUsernameFromContext(contextType), sendUserCredentialsResponse.username()),
      () -> Assertions.assertEquals(getPasswordFromContext(contextType), sendUserCredentialsResponse.password()),
      () -> Assertions.assertEquals(getTokenFromContext(contextType), sendUserCredentialsResponse.token()),
      () -> Assertions.assertNotNull(sendUserCredentialsResponse.expiresDate()),
      () -> Assertions.assertNotNull(sendUserCredentialsResponse.createdDate()),
      () -> Assertions.assertNotNull(sendUserCredentialsResponse.isActive())
    );

    setExpiresDateToContext(contextType, sendUserCredentialsResponse.expiresDate());
  }

  public void authorization(String contextType) {
    installSpecification(
      requestSpecification(BASE_URI.getUri()),
      responseSpecification(OK.getStatusCode())
    );

    UserAuthorizationResponse userAuthorizationResponse = given()
      .header(AUTHORIZATION.getHeader(), BEARER.getToken() + getTokenFromContext(contextType))
      .when()
      .get(USER_LOGIN.getEndpoint() + getUserIdFromContext(contextType))
      .then()
      .extract().response().as(UserAuthorizationResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertEquals(getUserIdFromContext(contextType), userAuthorizationResponse.userId()),
      () -> Assertions.assertEquals(getUsernameFromContext(contextType), userAuthorizationResponse.username()),
      () -> Assertions.assertTrue(userAuthorizationResponse.books().isEmpty())
    );
  }
}