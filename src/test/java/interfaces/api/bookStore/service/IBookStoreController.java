package interfaces.api.bookStore.service;

import interfaces.api.bookStore.dto.bookStoreList.GetBookStoreListResponse;
import interfaces.api.bookStore.dto.userList.AddBookRequest;

import java.util.List;
import java.util.Random;

public interface IBookStoreController {
  static AddBookRequest.CollectionOfIsbns getRandomBook(List<GetBookStoreListResponse> bookList) {
    GetBookStoreListResponse randomBook = bookList.get(new Random().nextInt(bookList.size()));
    return new AddBookRequest.CollectionOfIsbns(randomBook.isbn());
  }
}