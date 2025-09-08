package core.config.application.dto;

public class ApplicationConfig {
  private String favicon;
  private String profilePage;
  private String registrationPage;
  private String loginPage;
  private String baseUri;
  private String userRegistrationService;
  private String generateTokenService;
  private String sendCredentialService;
  private String userLoginService;

  public ApplicationConfig() {
  }

  public ApplicationConfig(
    String favicon,
    String profilePage,
    String registrationPage,
    String loginPage,
    String baseUri,
    String userRegistrationService,
    String generateTokenService,
    String sendCredentialService,
    String userLoginService) {
    this.favicon = favicon;
    this.profilePage = profilePage;
    this.registrationPage = registrationPage;
    this.loginPage = loginPage;
    this.baseUri = baseUri;
    this.userRegistrationService = userRegistrationService;
    this.generateTokenService = generateTokenService;
    this.sendCredentialService = sendCredentialService;
    this.userLoginService = userLoginService;
  }

  public String getFavicon() {
    return favicon;
  }

  public String getProfilePage() {
    return profilePage;
  }

  public String getRegistrationPage() {
    return registrationPage;
  }

  public String getLoginPage() {
    return loginPage;
  }

  public String getBaseUri() {
    return baseUri;
  }

  public String getUserRegistrationService() {
    return userRegistrationService;
  }

  public String getGenerateTokenService() {
    return generateTokenService;
  }

  public String getSendCredentialService() {
    return sendCredentialService;
  }

  public String getUserLoginService() {
    return userLoginService;
  }
}