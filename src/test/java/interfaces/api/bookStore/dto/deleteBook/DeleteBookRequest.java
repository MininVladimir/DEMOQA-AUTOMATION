package interfaces.api.bookStore.dto.deleteBook;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeleteBookRequest(
  String isbn,
  String userId) {

  public DeleteBookRequest(
    @JsonProperty("isbn") String isbn,
    @JsonProperty("userId") String userId
  ) {
    this.isbn = isbn;
    this.userId = userId;
  }
}