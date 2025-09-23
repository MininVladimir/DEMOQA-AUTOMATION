package interfaces.api.bookStore.dto.getBookStoreList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public record GetBookStoreListResponse(
  String isbn,
  String title,
  String subTitle,
  String author,
  String publishDate,
  String publisher,
  Integer pages,
  String description,
  String website) {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public GetBookStoreListResponse(
    @JsonProperty("isbn") String isbn,
    @JsonProperty("title") String title,
    @JsonProperty("subTitle") String subTitle,
    @JsonProperty("author") String author,
    @JsonProperty("publish_date") String publishDate,
    @JsonProperty("publisher") String publisher,
    @JsonProperty("pages") Integer pages,
    @JsonProperty("description") String description,
    @JsonProperty("website") String website) {
    this.isbn = isbn;
    this.title = title;
    this.subTitle = subTitle;
    this.author = author;
    this.publishDate = publishDate;
    this.publisher = publisher;
    this.pages = pages;
    this.description = description;
    this.website = website;
  }
}