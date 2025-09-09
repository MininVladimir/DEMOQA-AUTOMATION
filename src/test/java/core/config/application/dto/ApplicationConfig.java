package core.config.application.dto;

public class ApplicationConfig {
  private String faviconUrl;
  private String profilePageUrl;
  private String registrationPageUrl;
  private String loginPageUrl;
  private String baseUri;
  private String userRegistrationServiceEndPoint;
  private String generateTokenServiceEndPoint;
  private String sendCredentialServiceEndPoint;
  private String userAuthorizationServiceEndPoint;

  public ApplicationConfig() {
  }

  public ApplicationConfig(
    String faviconUrl,
    String profilePageUrl,
    String registrationPageUrl,
    String loginPageUrl,
    String baseUri,
    String userRegistrationServiceEndPoint,
    String generateTokenServiceEndPoint,
    String sendCredentialServiceEndPoint,
    String userAuthorizationServiceEndPoint) {
    this.faviconUrl = faviconUrl;
    this.profilePageUrl = profilePageUrl;
    this.registrationPageUrl = registrationPageUrl;
    this.loginPageUrl = loginPageUrl;
    this.baseUri = baseUri;
    this.userRegistrationServiceEndPoint = userRegistrationServiceEndPoint;
    this.generateTokenServiceEndPoint = generateTokenServiceEndPoint;
    this.sendCredentialServiceEndPoint = sendCredentialServiceEndPoint;
    this.userAuthorizationServiceEndPoint = userAuthorizationServiceEndPoint;
  }

  public String getFaviconUrl() {
    return faviconUrl;
  }

  public String getProfilePageUrl() {
    return profilePageUrl;
  }

  public String getRegistrationPageUrl() {
    return registrationPageUrl;
  }

  public String getLoginPageUrl() {
    return loginPageUrl;
  }

  public String getBaseUri() {
    return baseUri;
  }

  public String getUserRegistrationServiceEndPoint() {
    return userRegistrationServiceEndPoint;
  }

  public String getGenerateTokenServiceEndPoint() {
    return generateTokenServiceEndPoint;
  }

  public String getSendCredentialServiceEndPoint() {
    return sendCredentialServiceEndPoint;
  }

  public String getUserAuthorizationServiceEndPoint() {
    return userAuthorizationServiceEndPoint;
  }
}