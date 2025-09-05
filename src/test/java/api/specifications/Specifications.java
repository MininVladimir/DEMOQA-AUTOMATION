package api.specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

  public static RequestSpecification requestSpecification(String baseUri) {
    return new RequestSpecBuilder()
      .setBaseUri(baseUri)
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