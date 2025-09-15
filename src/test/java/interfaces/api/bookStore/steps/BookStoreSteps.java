package interfaces.api.bookStore.steps;

import interfaces.api.bookStore.controller.BookStoreController;
import interfaces.api.bookStore.dto.GetBookListResponse;
import io.qameta.allure.Step;

import java.util.List;

public class BookStoreSteps {
  static BookStoreController bookStoreController = new BookStoreController();

  @Step("[API] Get book list")
  public static List<GetBookListResponse> getBookList() {
    return bookStoreController.getBookList();
  }
}