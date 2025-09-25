package interfaces.api.bookStore.dto.verifyUserBookCollection;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public record VerifyUserBookCollectionResponse(
  String userId,
  String username,
  List<HashMap<String, Object>> userBookCollection) {

  public VerifyUserBookCollectionResponse(
    @JsonProperty("userId") String userId,
    @JsonProperty("username") String username,
    @JsonProperty("books") List<HashMap<String, Object>> userBookCollection
  ) {
    this.userId = userId;
    this.username = username;
    this.userBookCollection = userBookCollection;
  }
}