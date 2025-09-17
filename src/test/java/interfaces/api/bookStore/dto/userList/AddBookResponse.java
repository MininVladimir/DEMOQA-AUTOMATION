package interfaces.api.bookStore.dto.userList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public record AddBookResponse(List<HashMap<String, String>> books) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public AddBookResponse(
    @JsonProperty("books") List<HashMap<String, String>> books) {
    this.books = books;
  }
}