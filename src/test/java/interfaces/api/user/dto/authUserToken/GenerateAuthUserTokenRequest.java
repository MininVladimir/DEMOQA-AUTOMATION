package interfaces.api.user.dto.authUserToken;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GenerateAuthUserTokenRequest(
  String username,
  String password) {

  public GenerateAuthUserTokenRequest(
    @JsonProperty("userName") String username,
    @JsonProperty("password") String password) {
    this.username = username;
    this.password = password;
  }
}