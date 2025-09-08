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

  public static String getFaviconUri() {
    return applicationSingleton.getApplicationConfig().getFavicon();
  }

  public static String getProfilePageUri() {
    return applicationSingleton.getApplicationConfig().getProfilePage();
  }

  public static String getRegistrationPageUri() {
    return applicationSingleton.getApplicationConfig().getRegistrationPage();
  }

  public static String getLoginPageUri() {
    return applicationSingleton.getApplicationConfig().getLoginPage();
  }

  public static String getBaseUri() {
    return applicationSingleton.getApplicationConfig().getBaseUri();
  }

  public static String getUserRegistrationServiceEndpoint() {
    return applicationSingleton.getApplicationConfig().getUserRegistrationService();
  }

  public static String getGenerateTokenServiceEndpoint() {
    return applicationSingleton.getApplicationConfig().getGenerateTokenService();
  }

  public static String getSendCredentialServiceEndpoint() {
    return applicationSingleton.getApplicationConfig().getSendCredentialService();
  }

  public static String getUserLoginServiceEndpoint() {
    return applicationSingleton.getApplicationConfig().getUserLoginService();
  }
}