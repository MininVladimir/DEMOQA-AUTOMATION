package core.context.api;

public class ApiContext {
  private String username;
  private String password;
  private String userId;
  private String token;
  private String expiresDate;
  private String isbn;

  public String getUsername() {
    return username;
  }

  public void setUsername(String userName) {
    this.username = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getExpiresDate() {
    return expiresDate;
  }

  public void setExpiresDate(String expiresDate) {
    this.expiresDate = expiresDate;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}