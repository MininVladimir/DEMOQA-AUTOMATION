package core.config.application.applicationConfigReader;

import core.config.application.applicationSingleton.ApplicationSingleton;
import core.config.application.dto.ApplicationConfig;

public class ApplicationConfigReader {
  static ApplicationConfig applicationConfig;

  static {
    try {
      applicationConfig = ApplicationSingleton.getInstance().getApplicationConfig();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public enum AppConfigKey {
    BASE_URI,
    FAVICON_URL,
    PROFILE_PAGE_URL,
    REGISTRATION_PAGE_URL,
    LOGIN_PAGE_URL,
    USER_SERVICE,
    BOOK_STORE_SERVICE,
    DELETE_BOOK_SERVICE,
    GENERATE_TOKEN_ENDPOINT,
    SEND_CREDENTIAL_ENDPOINT,
    DELETE_BOOK_COLLECTION_ENDPOINT
  }

  public static String getApplicationConfigValue(AppConfigKey key) {
    return switch (key) {
      case BASE_URI -> applicationConfig.baseUri();
      case FAVICON_URL -> applicationConfig.faviconUrl();
      case PROFILE_PAGE_URL -> applicationConfig.profilePageUrl();
      case REGISTRATION_PAGE_URL -> applicationConfig.registrationPageUrl();
      case LOGIN_PAGE_URL -> applicationConfig.loginPageUrl();
      case USER_SERVICE -> applicationConfig.userService();
      case BOOK_STORE_SERVICE -> applicationConfig.bookStoreService();
      case DELETE_BOOK_SERVICE -> applicationConfig.deleteBookService();
      case GENERATE_TOKEN_ENDPOINT -> applicationConfig.generateTokenEndPoint();
      case SEND_CREDENTIAL_ENDPOINT -> applicationConfig.sendCredentialEndPoint();
      case DELETE_BOOK_COLLECTION_ENDPOINT -> applicationConfig.deleteBookCollectionEndPoint();
    };
  }
}