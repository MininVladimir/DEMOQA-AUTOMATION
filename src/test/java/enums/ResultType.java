package enums;

public enum ResultType {
  USER_AUTHORIZED_SUCCESSFULLY("User authorized successfully."),
  USER_REGISTER_SUCCESSFULLY("User Register Successfully."),
  USER_DELETED("User Deleted.");

  private final String result;

  ResultType(String result) {
    this.result = result;
  }

  public String getResult() {
    return result;
  }
}