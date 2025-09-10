package interfaces.api.user.dto.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserAuthorizationResponse(String userId, String username, List<Object> books) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public UserAuthorizationResponse(
    @JsonProperty("userId") String userId,
    @JsonProperty("username") String username,
    @JsonProperty("books") List<Object> books) {
    this.userId = userId;
    this.username = username;
    this.books = books;
  }
}