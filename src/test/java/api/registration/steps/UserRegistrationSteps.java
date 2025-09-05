package api.registration.steps;

import api.registration.controller.UserRegistrationController;
import io.qameta.allure.Step;

import static enums.ContextType.API;

public class UserRegistrationSteps {
  static UserRegistrationController userRegistrationController = new UserRegistrationController();

  @Step("[API] Registration")
  public static void registration() {
    userRegistrationController.registration(API.getContextType());
  }
}