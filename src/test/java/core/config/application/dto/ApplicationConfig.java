package core.config.application.dto;

public record ApplicationConfig(
  String baseUri,
  String faviconUrl,
  String profilePageUrl,
  String registrationPageUrl,
  String loginPageUrl,
  String userService,
  String bookStoreService,
  String generateTokenEndPoint,
  String sendCredentialEndPoint,
  String deleteBookCollectionEndPoint) {}