package enums;

public enum StatusCodeType {
  OK(200),
  CREATED(201);

  private final int statusCode;

  StatusCodeType(int statusCode) {
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return statusCode;
  }
}