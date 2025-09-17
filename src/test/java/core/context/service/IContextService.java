package core.context.service;

import core.context.api.ApiContextHolder;
import core.context.ui.UiContextHolder;

import java.util.HashMap;
import java.util.List;

import static core.generator.Generator.stringGenerator;

public interface IContextService {

  static void setFirstNameToContext() {
    UiContextHolder.getContext().setFirstname(stringGenerator(6, 0, 0, 0));
  }

  static void setLastNameToContext() {
    UiContextHolder.getContext().setLastname(stringGenerator(6, 0, 0, 0));
  }

  static void setUserUsernameToContext(String contextType) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setUsername(stringGenerator(6, 0, 0, 0));
      case "ui" -> UiContextHolder.getContext().setUsername(stringGenerator(6, 0, 0, 0));
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static void setPasswordToContext(String contextType) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setPassword(stringGenerator(3, 3, 3, 3));
      case "ui" -> UiContextHolder.getContext().setPassword(stringGenerator(3, 3, 3, 3));
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static void setUserIdToContext(String contextType, String userId) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setUserId(userId);
      case "ui" -> UiContextHolder.getContext().setUserId(userId);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static String getUserIdFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> ApiContextHolder.getContext().getUserId();
      case "ui" -> UiContextHolder.getContext().getUserId();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  static String getUsernameFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> ApiContextHolder.getContext().getUsername();
      case "ui" -> UiContextHolder.getContext().getUsername();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  static String getPasswordFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> ApiContextHolder.getContext().getPassword();
      case "ui" -> UiContextHolder.getContext().getPassword();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  static void setTokenToContext(String contextType, String token) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setToken(token);
      case "ui" -> UiContextHolder.getContext().setToken(token);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static String getTokenFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> ApiContextHolder.getContext().getToken();
      case "ui" -> UiContextHolder.getContext().getToken();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  static void setExpiresDateToContext(String contextType, String expiresDate) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setExpiresDate(expiresDate);
      case "ui" -> UiContextHolder.getContext().setExpiresDate(expiresDate);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static void setIsbnToContext(String contextType, List<HashMap<String, String>> bookCollection) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setBookCollection(bookCollection);
      case "ui" -> UiContextHolder.getContext().setBookCollection(bookCollection);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  static List<HashMap<String, String>> getIsbnFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> ApiContextHolder.getContext().getBookCollection();
      case "ui" -> UiContextHolder.getContext().getBookCollection();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }
}