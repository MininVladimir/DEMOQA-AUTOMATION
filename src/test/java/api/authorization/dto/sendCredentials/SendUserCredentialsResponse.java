package api.authorization.dto.sendCredentials;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public record SendUserCredentialsResponse(String userId, String username, String password, String token, String expiresDate, String createdDate, Boolean isActive) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public SendUserCredentialsResponse(
    @JsonProperty("userId") String userId,
    @JsonProperty("username") String username,
    @JsonProperty("password") String password,
    @JsonProperty("token") String token,
    @JsonProperty("expires") String expiresDate,
    @JsonProperty("created_date") String createdDate,
    @JsonProperty("isActive") Boolean isActive) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.token = token;
    this.expiresDate = expiresDate;
    this.createdDate = createdDate;
    this.isActive = isActive;
  }
}