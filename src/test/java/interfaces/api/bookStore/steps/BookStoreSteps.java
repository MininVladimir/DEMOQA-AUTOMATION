package interfaces.api.bookStore.steps;

import interfaces.api.bookStore.controller.BookStoreController;
import interfaces.api.bookStore.dto.bookStoreList.GetBookStoreListResponse;
import io.qameta.allure.Step;

import java.util.List;

import static enums.ContextType.API;

public class BookStoreSteps {
  static BookStoreController bookStoreController = new BookStoreController();

  @Step("[API] Get book list")
  public static List<GetBookStoreListResponse> getBookList() {
    return bookStoreController.getBookList();
  }

  @Step("[API] Add book")
  public static void addBook() {
    bookStoreController.addBook(API.getContextType(), getBookList(), 2);
  }
}