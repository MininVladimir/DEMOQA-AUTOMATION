package core.config.webDriver.dto;

public class WebDriverConfig {
  private String browser;
  private boolean headlessMode;
  private String browserScreenSize;
  private int pageLoadedTimeoutMilliseconds;
  private int timeoutMilliseconds;
  private String pageLoadStrategy;

  public WebDriverConfig() {
  }

  public WebDriverConfig(
    String browser,
    boolean headlessMode,
    String browserScreenSize,
    int pageLoadedTimeoutMilliseconds,
    int timeoutMilliseconds,
    String pageLoadStrategy) {
    this.browser = browser;
    this.headlessMode = headlessMode;
    this.browserScreenSize = browserScreenSize;
    this.pageLoadedTimeoutMilliseconds = pageLoadedTimeoutMilliseconds;
    this.timeoutMilliseconds = timeoutMilliseconds;
    this.pageLoadStrategy = pageLoadStrategy;
  }

  public String getBrowser() {
    return browser;
  }

  public boolean isHeadlessMode() {
    return headlessMode;
  }

  public String getBrowserScreenSize() {
    return browserScreenSize;
  }

  public int getPageLoadedTimeoutMilliseconds() {
    return pageLoadedTimeoutMilliseconds;
  }

  public int getTimeoutMilliseconds() {
    return timeoutMilliseconds;
  }

  public String getPageLoadStrategy() {
    return pageLoadStrategy;
  }
}