package interfaces.api.registration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserRegistrationRequest(String username, String password) {

  public UserRegistrationRequest(
    @JsonProperty("userName") String username,
    @JsonProperty("password") String password) {
    this.username = username;
    this.password = password;
  }
}