package interfaces.api.bookStore.service;

import interfaces.api.bookStore.dto.bookStoreList.GetBookStoreListResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public interface IBookStoreController {

  static List<HashMap<String, String>> getBookCollection(List<GetBookStoreListResponse> bookList, int bookCount) {
    List<HashMap<String, String>> bookCollection = new ArrayList<>();
    HashSet<String> addedBook = new HashSet<>();
    Random random = new Random();

    while (bookCollection.size() < bookCount) {
      String isbn = bookList.get(random.nextInt(bookList.size())).isbn();
      if (!addedBook.contains(isbn)) {
        HashMap<String, String> book = new HashMap<>();
        book.put("isbn", isbn);
        bookCollection.add(book);
        addedBook.add(isbn);
      }
    }
    return bookCollection;
  }
}