package interfaces.api.bookStore.dto.userList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AddBookResponse(List<Books> books) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public AddBookResponse(
    @JsonProperty("books") List<Books> books) {
    this.books = books;
  }

  public record Books(String isbn) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Books(@JsonProperty("isbn") String isbn) {
      this.isbn = isbn;
    }
  }
}