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

  public enum ConfigKey {
    FAVICON_URL,
    PROFILE_PAGE_URL,
    REGISTRATION_PAGE_URL,
    LOGIN_PAGE_URL,
    BASE_URI,
    USER_REGISTRATION_SERVICE_ENDPOINT,
    GENERATE_TOKEN_SERVICE_ENDPOINT,
    SEND_CREDENTIAL_SERVICE_ENDPOINT,
    USER_AUTHORIZATION_SERVICE_ENDPOINT
  }

  public static String getApplicationConfigValue(ConfigKey key) {
    return switch (key) {
      case FAVICON_URL -> applicationConfig.getFaviconUrl();
      case PROFILE_PAGE_URL -> applicationConfig.getProfilePageUrl();
      case REGISTRATION_PAGE_URL -> applicationConfig.getRegistrationPageUrl();
      case LOGIN_PAGE_URL -> applicationConfig.getLoginPageUrl();
      case BASE_URI -> applicationConfig.getBaseUri();
      case USER_REGISTRATION_SERVICE_ENDPOINT -> applicationConfig.getUserRegistrationServiceEndPoint();
      case GENERATE_TOKEN_SERVICE_ENDPOINT -> applicationConfig.getGenerateTokenServiceEndPoint();
      case SEND_CREDENTIAL_SERVICE_ENDPOINT -> applicationConfig.getSendCredentialServiceEndPoint();
      case USER_AUTHORIZATION_SERVICE_ENDPOINT -> applicationConfig.getUserAuthorizationServiceEndPoint();
    };
  }
}