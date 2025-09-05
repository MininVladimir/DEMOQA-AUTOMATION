package enums;

public enum StatusType {
  SUCCESS("Success");

  private final String status;

  StatusType(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}