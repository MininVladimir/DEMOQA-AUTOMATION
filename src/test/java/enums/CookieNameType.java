package enums;

public enum CookieNameType {
  EXPIRES("expires"),
  TOKEN("token"),
  USER_ID("userID"),
  USERNAME("userName");

  private final String cookie;

  CookieNameType(String cookie) {
    this.cookie = cookie;
  }

  public String getCookieName() {
    return cookie;
  }
}