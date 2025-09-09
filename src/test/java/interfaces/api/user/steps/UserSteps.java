package interfaces.api.user.steps;

import interfaces.api.user.controller.UserController;
import core.context.service.IContextService;
import io.qameta.allure.Step;

import static enums.ContextType.API;

public class UserSteps implements IContextService {
  static UserController userController = new UserController();

  @Step("[API] Registration")
  public static void registration() {
    userController.registration(API.getContextType());
  }

  @Step("[API] Generate token")
  private static void generateToken() {
    userController.generateToken(API.getContextType());
  }

  @Step("[API] Send credentials")
  private static void sendCredentials() {
    userController.sendCredentials(API.getContextType());
  }

  @Step("[API] Authorization")
  private static void authorization() {
    userController.authorization(API.getContextType());
  }

  @Step("[API] Login")
  public static void login() {
    generateToken();
    sendCredentials();
    authorization();
  }
}