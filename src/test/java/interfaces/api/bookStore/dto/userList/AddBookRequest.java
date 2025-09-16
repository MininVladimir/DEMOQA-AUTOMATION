package interfaces.api.bookStore.dto.userList;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AddBookRequest(
  String userId,
  List<CollectionOfIsbns> collectionOfIsbns) {

  public AddBookRequest(
    @JsonProperty("userId") String userId,
    @JsonProperty("collectionOfIsbns") List<CollectionOfIsbns> collectionOfIsbns
  ) {
    this.userId = userId;
    this.collectionOfIsbns = collectionOfIsbns;
  }

  public record CollectionOfIsbns(String isbn) {

    public CollectionOfIsbns(@JsonProperty("isbn") String isbn) {
      this.isbn = isbn;
    }
  }
}