package core.context.service;

import core.context.api.ApiContextHolder;
import core.context.ui.UiContextHolder;

import static core.generator.Generator.stringGenerator;

public interface IContextService {
  default void setUserUsernameToContext(String contextType) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setUsername(stringGenerator(6, 0, 0, 0));
      case "ui" -> UiContextHolder.getContext().setUsername(stringGenerator(6, 0, 0, 0));
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  default void setPasswordToContext(String contextType) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setPassword(stringGenerator(3, 3, 3, 3));
      case "ui" -> UiContextHolder.getContext().setPassword(stringGenerator(3, 3, 3, 3));
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  default void setUserIdToContext(String contextType, String userId) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setUserId(userId);
      case "ui" -> UiContextHolder.getContext().setUserId(userId);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  default String getUserIdFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> ApiContextHolder.getContext().getUserId();
      case "ui" -> UiContextHolder.getContext().getUserId();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  default String getUsernameFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> ApiContextHolder.getContext().getUsername();
      case "ui" -> UiContextHolder.getContext().getUsername();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  default String getPasswordFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> ApiContextHolder.getContext().getPassword();
      case "ui" -> UiContextHolder.getContext().getPassword();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  default void setTokenToContext(String contextType, String token) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setToken(token);
      case "ui" -> UiContextHolder.getContext().setToken(token);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }

  default String getTokenFromContext(String contextType) {
    return switch (contextType) {
      case "api" -> ApiContextHolder.getContext().getToken();
      case "ui" -> UiContextHolder.getContext().getToken();
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    };
  }

  default void setExpiresDateToContext(String contextType, String expiresDate) {
    switch (contextType) {
      case "api" -> ApiContextHolder.getContext().setExpiresDate(expiresDate);
      case "ui" -> UiContextHolder.getContext().setExpiresDate(expiresDate);
      default -> throw new IllegalStateException("Unexpected value: " + contextType);
    }
  }
}