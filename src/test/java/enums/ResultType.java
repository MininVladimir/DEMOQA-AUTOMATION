package enums;

public enum ResultType {
  USER_AUTHORIZED_SUCCESSFULLY("User authorized successfully.");

  private final String result;

  ResultType(String result) {
    this.result = result;
  }

  public String getResult() {
    return result;
  }
}