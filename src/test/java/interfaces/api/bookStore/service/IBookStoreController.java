package interfaces.api.bookStore.service;

import interfaces.api.bookStore.dto.bookStoreList.GetBookStoreListResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public interface IBookStoreController {

  private static HashMap<String, Object> getBook(String isbn, List<GetBookStoreListResponse> filteredList) {
    HashMap<String, Object> book = new HashMap<>();
    book.put("isbn", isbn);
    book.put("title", filteredList.getFirst().title());
    book.put("subTitle", filteredList.getFirst().subTitle());
    book.put("author", filteredList.getFirst().author());
    book.put("publishDate", filteredList.getFirst().publishDate());
    book.put("publisher", filteredList.getFirst().publisher());
    book.put("pages", filteredList.getFirst().pages());
    book.put("description", filteredList.getFirst().description());
    book.put("website", filteredList.getFirst().website());
    return book;
  }

  static List<HashMap<String, Object>> getBookCollection(List<GetBookStoreListResponse> bookList, int bookCount) {
    List<HashMap<String, Object>> bookCollection = new ArrayList<>();
    HashSet<String> addedBook = new HashSet<>();
    Random random = new Random();

    while (bookCollection.size() < bookCount) {
      String isbn = bookList.get(random.nextInt(bookList.size())).isbn();
      List<GetBookStoreListResponse> filteredList = bookList.stream().filter(x -> x.isbn().equals(isbn)).toList();
      if (!addedBook.contains(isbn)) {
        HashMap<String, Object> book = getBook(isbn, filteredList);
        bookCollection.add(book);
        addedBook.add(isbn);
      }
    }
    return bookCollection;
  }
}