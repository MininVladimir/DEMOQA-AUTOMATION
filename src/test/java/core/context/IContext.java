package core.context;

import java.util.HashMap;
import java.util.List;

import static core.generator.Generator.stringGenerator;

public interface IContext {

  static void setFirstNameToContext() {
    ContextHolder.getContext().setFirstname(stringGenerator(6, 0, 0, 0));
  }

  static void setLastNameToContext() {
    ContextHolder.getContext().setLastname(stringGenerator(6, 0, 0, 0));
  }

  static void setUserUsernameToContext() {
    ContextHolder.getContext().setUsername(stringGenerator(6, 0, 0, 0));
  }

  static void setPasswordToContext() {
    ContextHolder.getContext().setPassword(stringGenerator(3, 3, 3, 3));
  }

  static void setUserIdToContext(String userId) {
    ContextHolder.getContext().setUserId(userId);
  }

  static String getUserIdFromContext() {
    return ContextHolder.getContext().getUserId();
  }

  static String getUsernameFromContext() {
    return ContextHolder.getContext().getUsername();
  }

  static String getPasswordFromContext() {
    return ContextHolder.getContext().getPassword();
  }

  static void setTokenToContext(String token) {
    ContextHolder.getContext().setToken(token);
  }

  static String getTokenFromContext() {
    return ContextHolder.getContext().getToken();
  }

  static void setExpiresDateToContext(String expiresDate) {
    ContextHolder.getContext().setExpiresDate(expiresDate);
  }

  static void setBookCollectionToContext(List<HashMap<String, Object>> bookCollection) {
    ContextHolder.getContext().setBookCollection(bookCollection);
  }

  static List<HashMap<String, Object>> getBookCollectionFromContext() {
    return ContextHolder.getContext().getBookCollection();
  }
}