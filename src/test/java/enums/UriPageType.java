package enums;

public enum UriPageType {
  BASE_URI("https://demoqa.com/"),
  FAVICON_URI("https://demoqa.com/favicon.png"),
  PROFILE_URI("https://demoqa.com/profile");

  private final String uri;

  UriPageType(String uri) {
    this.uri = uri;
  }

  public String getUri() {
    return uri;
  }
}