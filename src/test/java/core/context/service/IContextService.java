package core.context.service;

import core.context.api.ApiContext;
import core.context.api.ApiContextHolder;
import core.context.ui.UiContext;
import core.context.ui.UiContextHolder;

import static core.generator.Generator.stringGenerator;

public interface IContextService {
  UiContext uiContext = UiContextHolder.getContext();
  ApiContext apiCOntext = ApiContextHolder.getContext();

  static void setFirstNameToContext() {
    uiContext.setFirstname(stringGenerator(6, 0, 0, 0));
  }

  static void setLastNameToContext() {
    uiContext.setLastname(stringGenerator(6, 0, 0, 0));
  }

  static void setUserUsernameToContext(String contextType) {
    switch (contextType) {
      case "api" -> apiCOntext.setUsername(stringGenerator(6, 0, 0, 0));
      case "ui" -> uiContext.setUsername(stringGenerator(6, 0, 0, 0));
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static void setPasswordToContext(String contextType) {
    switch (contextType) {
      case "api" -> apiCOntext.setPassword(stringGenerator(3, 3, 3, 3));
      case "ui" -> uiContext.setPassword(stringGenerator(3, 3, 3, 3));
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static void setUserIdToContext(String contextType, String userId) {
    switch (contextType) {
      case "api" -> apiCOntext.setUserId(userId);
      case "ui" -> uiContext.setUserId(userId);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static String getUserIdFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> apiCOntext.getUserId();
      case "ui" -> uiContext.getUserId();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  static String getUsernameFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> apiCOntext.getUsername();
      case "ui" -> uiContext.getUsername();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  static String getPasswordFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> apiCOntext.getPassword();
      case "ui" -> uiContext.getPassword();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  static void setTokenToContext(String contextType, String token) {
    switch (contextType) {
      case "api" -> apiCOntext.setToken(token);
      case "ui" -> uiContext.setToken(token);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static String getTokenFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> apiCOntext.getToken();
      case "ui" -> uiContext.getToken();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  static void setExpiresDateToContext(String contextType, String expiresDate) {
    switch (contextType) {
      case "api" -> apiCOntext.setExpiresDate(expiresDate);
      case "ui" -> uiContext.setExpiresDate(expiresDate);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }
}