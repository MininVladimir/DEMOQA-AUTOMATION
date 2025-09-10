package core.config.application.dto;

public record ApplicationConfig(
  String faviconUrl,
  String profilePageUrl,
  String registrationPageUrl,
  String loginPageUrl,
  String baseUri,
  String userServiceEndPoint,
  String generateTokenServiceEndPoint,
  String sendCredentialServiceEndPoint) {

  public ApplicationConfig(
    String faviconUrl,
    String profilePageUrl,
    String registrationPageUrl,
    String loginPageUrl,
    String baseUri,
    String userServiceEndPoint,
    String generateTokenServiceEndPoint,
    String sendCredentialServiceEndPoint) {
    this.faviconUrl = faviconUrl;
    this.profilePageUrl = profilePageUrl;
    this.registrationPageUrl = registrationPageUrl;
    this.loginPageUrl = loginPageUrl;
    this.baseUri = baseUri;
    this.userServiceEndPoint = userServiceEndPoint;
    this.generateTokenServiceEndPoint = generateTokenServiceEndPoint;
    this.sendCredentialServiceEndPoint = sendCredentialServiceEndPoint;
  }
}