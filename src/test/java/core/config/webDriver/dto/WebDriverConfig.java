package core.config.webDriver.dto;

public record WebDriverConfig(
  String browserScreenSize,
  int pageLoadedTimeoutMilliseconds,
  int timeoutMilliseconds,
  String pageLoadStrategy) {

  public WebDriverConfig(
    String browserScreenSize,
    int pageLoadedTimeoutMilliseconds,
    int timeoutMilliseconds,
    String pageLoadStrategy) {
    this.browserScreenSize = browserScreenSize;
    this.pageLoadedTimeoutMilliseconds = pageLoadedTimeoutMilliseconds;
    this.timeoutMilliseconds = timeoutMilliseconds;
    this.pageLoadStrategy = pageLoadStrategy;
  }
}