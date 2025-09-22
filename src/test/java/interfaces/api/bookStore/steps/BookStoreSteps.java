package interfaces.api.bookStore.steps;

import interfaces.api.bookStore.controller.BookStoreController;
import interfaces.api.bookStore.dto.bookStoreList.GetBookStoreListResponse;
import io.qameta.allure.Step;

import java.util.List;

import static core.generator.Generator.getRandomNumberInTheRange;

public class BookStoreSteps {
  static BookStoreController bookStoreController = new BookStoreController();

  @Step("[API] Get book list")
  public static List<GetBookStoreListResponse> getBookList() {
    return bookStoreController.getBookList();
  }

  @Step("[API] Add book collection")
  public static void addBookCollection() {
    bookStoreController.addBookCollection(
      getBookList(),
      getRandomNumberInTheRange(2, 4)
    );
  }
}