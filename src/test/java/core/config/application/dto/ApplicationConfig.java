package core.config.application.dto;

public record ApplicationConfig(
  String faviconUrl,
  String profilePageUrl,
  String registrationPageUrl,
  String loginPageUrl,
  String baseUri,
  String userRegistrationServiceEndPoint,
  String generateTokenServiceEndPoint,
  String sendCredentialServiceEndPoint,
  String userAuthorizationServiceEndPoint) {

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
}