package core.listener.restAssuredListener;

import io.qameta.allure.restassured.AllureRestAssured;

public interface IRestAssuredListener {
  AllureRestAssured allureFilter = new AllureRestAssured()
    .setRequestAttachmentName("Request")
    .setResponseAttachmentName("Response");
}