package api.authorization.steps;

import api.authorization.controller.UserAuthorizationController;
import core.context.service.IContextService;
import io.qameta.allure.Step;

import static enums.ContextType.API;

public class UserAuthorizationSteps implements IContextService {
  static UserAuthorizationController userAuthorizationController = new UserAuthorizationController();

  @Step("[API] Generate token")
  private static void generateToken() {
    userAuthorizationController.generateToken(API.getContextType());
  }

  @Step("[API] Send credentials")
  private static void sendCredentials() {
    userAuthorizationController.sendCredentials(API.getContextType());
  }

  @Step("[API] Authorization")
  private static void authorization() {
    userAuthorizationController.authorization(API.getContextType());
  }

  @Step("[API] Login")
  public static void login() {
    generateToken();
    sendCredentials();
    authorization();
  }
}