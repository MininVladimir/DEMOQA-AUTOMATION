package interfaces.api.bookStore.dto.userList;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public record AddBookRequest(
  String userId,
  List<HashMap<String, String>> collectionOfIsbns) {

  public AddBookRequest(
    @JsonProperty("userId") String userId,
    @JsonProperty("collectionOfIsbns") List<HashMap<String, String>> collectionOfIsbns
  ) {
    this.userId = userId;
    this.collectionOfIsbns = collectionOfIsbns;
  }
}