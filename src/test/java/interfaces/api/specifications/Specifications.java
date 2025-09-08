package interfaces.api.specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static core.config.application.applicationConfigReader.ApplicationConfigReader.ConfigKey.BASE_URI;
import static core.config.application.applicationConfigReader.ApplicationConfigReader.getApplicationConfigValue;

public class Specifications {

  public static RequestSpecification requestSpecification() {
    return new RequestSpecBuilder()
      .setBaseUri(getApplicationConfigValue(BASE_URI))
      .setContentType(ContentType.JSON)
      .log(LogDetail.ALL)
      .build();
  }

  public static ResponseSpecification responseSpecification(int statusCode) {
    return new ResponseSpecBuilder()
      .expectStatusCode(statusCode)
      .log(LogDetail.ALL)
      .build();
  }

  public static void installSpecification(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
    RestAssured.requestSpecification = requestSpecification;
    RestAssured.responseSpecification = responseSpecification;
  }

  public static void removeSpecifications() {
    RestAssured.requestSpecification = null;
    RestAssured.responseSpecification = null;
  }
}