package interfaces.api.user.controller;

import core.listener.restAssuredListener.IRestAssuredListener;
import interfaces.api.user.dto.authUserToken.GenerateAuthUserTokenRequest;
import interfaces.api.user.dto.authUserToken.GenerateAuthUserTokenResponse;
import interfaces.api.user.dto.authorization.UserAuthorizationResponse;
import interfaces.api.user.dto.registration.UserRegistrationRequest;
import interfaces.api.user.dto.registration.UserRegistrationResponse;
import interfaces.api.user.dto.sendCredentials.SendUserCredentialsRequest;
import interfaces.api.user.dto.sendCredentials.SendUserCredentialsResponse;
import core.context.IContext;
import org.junit.jupiter.api.Assertions;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.GENERATE_TOKEN_ENDPOINT;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.SEND_CREDENTIAL_ENDPOINT;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.AppConfigKey.USER_SERVICE;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;
import static enums.StatusCodeType.CREATED;
import static enums.StatusCodeType.NO_CONTENT;
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

public class UserController implements IContext, IRestAssuredListener {

  public void registration() {
    IContext.setUserUsernameToContext();
    IContext.setPasswordToContext();

    installSpecification(
      requestSpecification(),
      responseSpecification(CREATED.getStatusCode())
    );

    UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest(IContext.getUsernameFromContext(), IContext.getPasswordFromContext());
    UserRegistrationResponse userRegistrationResponse = given()
      .filter(allureFilter)
      .body(userRegistrationRequest)
      .when()
      .post(getApplicationConfigValue(USER_SERVICE))
      .then()
      .extract().response().as(UserRegistrationResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertNotNull(userRegistrationResponse.userId()),
      () -> Assertions.assertEquals(userRegistrationRequest.username(), userRegistrationResponse.username()),
      () -> Assertions.assertTrue(userRegistrationResponse.books().isEmpty())
    );

    IContext.setUserIdToContext(userRegistrationResponse.userId());
  }

  public void generateToken() {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    GenerateAuthUserTokenRequest generateAuthUserTokenRequest = new GenerateAuthUserTokenRequest(IContext.getUsernameFromContext(), IContext.getPasswordFromContext());
    GenerateAuthUserTokenResponse generateAuthUserTokenResponse = given()
      .filter(allureFilter)
      .body(generateAuthUserTokenRequest)
      .when()
      .post(getApplicationConfigValue(GENERATE_TOKEN_ENDPOINT))
      .then()
      .extract().response().as(GenerateAuthUserTokenResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertNotNull(generateAuthUserTokenResponse.token()),
      () -> Assertions.assertNotNull(generateAuthUserTokenResponse.expiresDate()),
      () -> Assertions.assertEquals(SUCCESS.getStatus(), generateAuthUserTokenResponse.status()),
      () -> Assertions.assertEquals(USER_AUTHORIZED_SUCCESSFULLY.getResult(), generateAuthUserTokenResponse.result())
    );

    IContext.setTokenToContext(generateAuthUserTokenResponse.token());
  }

  public void sendCredentials() {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    SendUserCredentialsRequest sendUserCredentialsRequest = new SendUserCredentialsRequest(IContext.getUsernameFromContext(), IContext.getPasswordFromContext());
    SendUserCredentialsResponse sendUserCredentialsResponse = given()
      .filter(allureFilter)
      .body(sendUserCredentialsRequest)
      .when()
      .post(getApplicationConfigValue(SEND_CREDENTIAL_ENDPOINT))
      .then()
      .extract().response().as(SendUserCredentialsResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertEquals(IContext.getUserIdFromContext(), sendUserCredentialsResponse.userId()),
      () -> Assertions.assertEquals(IContext.getUsernameFromContext(), sendUserCredentialsResponse.username()),
      () -> Assertions.assertEquals(IContext.getPasswordFromContext(), sendUserCredentialsResponse.password()),
      () -> Assertions.assertEquals(IContext.getTokenFromContext(), sendUserCredentialsResponse.token()),
      () -> Assertions.assertNotNull(sendUserCredentialsResponse.expiresDate()),
      () -> Assertions.assertNotNull(sendUserCredentialsResponse.createdDate()),
      () -> Assertions.assertNotNull(sendUserCredentialsResponse.isActive())
    );

    IContext.setExpiresDateToContext(sendUserCredentialsResponse.expiresDate());
  }

  public void authorization() {
    installSpecification(
      requestSpecification(),
      responseSpecification(OK.getStatusCode())
    );

    UserAuthorizationResponse userAuthorizationResponse = given()
      .filter(allureFilter)
      .header(AUTHORIZATION.getHeader(), BEARER.getToken() + IContext.getTokenFromContext())
      .when()
      .get(getApplicationConfigValue(USER_SERVICE) + IContext.getUserIdFromContext())
      .then()
      .extract().response().as(UserAuthorizationResponse.class);

    removeSpecifications();

    Assertions.assertAll(
      () -> Assertions.assertEquals(IContext.getUserIdFromContext(), userAuthorizationResponse.userId()),
      () -> Assertions.assertEquals(IContext.getUsernameFromContext(), userAuthorizationResponse.username()),
      () -> Assertions.assertTrue(userAuthorizationResponse.books().isEmpty())
    );
  }

  public void deleteUser() {
    installSpecification(
      requestSpecification(),
      responseSpecification(NO_CONTENT.getStatusCode())
    );

    given()
      .filter(allureFilter)
      .header(AUTHORIZATION.getHeader(), BEARER.getToken() + IContext.getTokenFromContext())
      .when()
      .delete(getApplicationConfigValue(USER_SERVICE) + IContext.getUserIdFromContext());

    removeSpecifications();
  }
}