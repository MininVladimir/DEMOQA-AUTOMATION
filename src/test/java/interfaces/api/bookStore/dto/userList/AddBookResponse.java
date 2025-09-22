package interfaces.api.bookStore.dto.userList;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public record AddBookResponse(List<HashMap<String, Object>> userBookCollection) {

  public AddBookResponse(
    @JsonProperty("books") List<HashMap<String, Object>> userBookCollection
  ) {
    this.userBookCollection = userBookCollection;
  }
}