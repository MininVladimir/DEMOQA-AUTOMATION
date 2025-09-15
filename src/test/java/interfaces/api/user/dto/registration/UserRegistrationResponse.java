package interfaces.api.user.dto.registration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserRegistrationResponse(
  String userId,
  String username,
  List<Object> books) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public UserRegistrationResponse(
    @JsonProperty("userID") String userId,
    @JsonProperty("username") String username,
    @JsonProperty("books") List<Object> books) {
    this.userId = userId;
    this.username = username;
    this.books = books;
  }
}