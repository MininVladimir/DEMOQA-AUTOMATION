package interfaces.api.user.dto.sendCredentials;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SendUserCredentialsRequest(String username, String password) {

  public SendUserCredentialsRequest(
    @JsonProperty("userName") String username,
    @JsonProperty("password") String password) {
    this.username = username;
    this.password = password;
  }
}