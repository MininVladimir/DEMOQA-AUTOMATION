package interfaces.api.bookStore.dto.addBooks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public record AddBookCollectionResponse(List<HashMap<String, Object>> userBookCollection) {

  public AddBookCollectionResponse(
    @JsonProperty("books") List<HashMap<String, Object>> userBookCollection
  ) {
    this.userBookCollection = userBookCollection;
  }
}