package interfaces.api.user.steps;

import interfaces.api.user.controller.UserController;
import core.context.IContext;
import io.qameta.allure.Step;

public class UserSteps implements IContext {
  static UserController userController = new UserController();

  @Step("[API] Generate token")
  private static void generateToken() {
    userController.generateToken();
  }

  @Step("[API] Send credentials")
  private static void sendCredentials() {
    userController.sendCredentials();
  }

  @Step("[API] Authorization")
  private static void authorization() {
    userController.authorization();
  }

  @Step("[API] Registration")
  public static void registration() {
    userController.registration();
  }

  @Step("[API] Login")
  public static void login() {
    generateToken();
    sendCredentials();
    authorization();
  }

  @Step("[API] Delete user")
  public static void deleteUser() {
    userController.deleteUser();
  }
}