package interfaces.api.bookStore.dto.addBooks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public record AddBookCollectionRequest(
  String userId,
  List<HashMap<String, Object>> collectionOfIsbns) {

  public AddBookCollectionRequest(
    @JsonProperty("userId") String userId,
    @JsonProperty("collectionOfIsbns") List<HashMap<String, Object>> collectionOfIsbns
  ) {
    this.userId = userId;
    this.collectionOfIsbns = collectionOfIsbns;
  }
}