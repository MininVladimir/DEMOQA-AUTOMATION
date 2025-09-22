package core.context;

import java.util.HashMap;
import java.util.List;

public class Context {
  private String firstname;
  private String lastname;
  private String username;
  private String password;
  private String userId;
  private String token;
  private String expiresDate;
  private List<HashMap<String, Object>> bookCollection;

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

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

  public List<HashMap<String, Object>> getBookCollection() {
    return bookCollection;
  }

  public void setBookCollection(List<HashMap<String, Object>> bookCollection) {
    this.bookCollection = bookCollection;
  }
}