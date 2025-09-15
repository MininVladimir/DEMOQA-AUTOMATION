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
    FAVICON_URL,
    PROFILE_PAGE_URL,
    REGISTRATION_PAGE_URL,
    LOGIN_PAGE_URL,
    BASE_URI,
    USER_SERVICE_ENDPOINT,
    GENERATE_TOKEN_SERVICE_ENDPOINT,
    SEND_CREDENTIAL_SERVICE_ENDPOINT,
    BOOK_STORE_SERVICE_ENDPOINT
  }

  public static String getApplicationConfigValue(AppConfigKey key) {
    return switch (key) {
      case FAVICON_URL -> applicationConfig.faviconUrl();
      case PROFILE_PAGE_URL -> applicationConfig.profilePageUrl();
      case REGISTRATION_PAGE_URL -> applicationConfig.registrationPageUrl();
      case LOGIN_PAGE_URL -> applicationConfig.loginPageUrl();
      case BASE_URI -> applicationConfig.baseUri();
      case USER_SERVICE_ENDPOINT -> applicationConfig.userServiceEndPoint();
      case GENERATE_TOKEN_SERVICE_ENDPOINT -> applicationConfig.generateTokenServiceEndPoint();
      case SEND_CREDENTIAL_SERVICE_ENDPOINT -> applicationConfig.sendCredentialServiceEndPoint();
      case BOOK_STORE_SERVICE_ENDPOINT -> applicationConfig.bookStoreServiceEndpoint();
    };
  }
}