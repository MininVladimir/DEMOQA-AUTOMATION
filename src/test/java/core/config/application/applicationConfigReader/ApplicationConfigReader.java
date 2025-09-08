package core.config.application.applicationConfigReader;

import core.config.application.applicationSingleton.ApplicationSingleton;

public class ApplicationConfigReader {
  static ApplicationSingleton applicationSingleton;

  static {
    try {
      applicationSingleton = ApplicationSingleton.getInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public enum ConfigKey {
    FAVICON,
    PROFILE_PAGE,
    REGISTRATION_PAGE,
    LOGIN_PAGE,
    BASE_URI,
    USER_REGISTRATION_SERVICE,
    GENERATE_TOKEN_SERVICE,
    SEND_CREDENTIAL_SERVICE,
    USER_LOGIN_SERVICE
  }

  public static String getApplicationConfigValue(ConfigKey key) {
    return switch (key) {
      case FAVICON -> applicationSingleton.getApplicationConfig().getFavicon();
      case PROFILE_PAGE -> applicationSingleton.getApplicationConfig().getProfilePage();
      case REGISTRATION_PAGE -> applicationSingleton.getApplicationConfig().getRegistrationPage();
      case LOGIN_PAGE -> applicationSingleton.getApplicationConfig().getLoginPage();
      case BASE_URI -> applicationSingleton.getApplicationConfig().getBaseUri();
      case USER_REGISTRATION_SERVICE -> applicationSingleton.getApplicationConfig().getUserRegistrationService();
      case GENERATE_TOKEN_SERVICE -> applicationSingleton.getApplicationConfig().getGenerateTokenService();
      case SEND_CREDENTIAL_SERVICE -> applicationSingleton.getApplicationConfig().getSendCredentialService();
      case USER_LOGIN_SERVICE -> applicationSingleton.getApplicationConfig().getUserLoginService();
    };
  }
}