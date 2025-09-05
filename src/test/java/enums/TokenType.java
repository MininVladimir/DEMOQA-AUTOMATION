package enums;

public enum TokenType {
  BEARER("Bearer ");

  private final String token;

  TokenType(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}