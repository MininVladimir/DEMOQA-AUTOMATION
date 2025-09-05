package enums;

public enum HeaderType {
  AUTHORIZATION("Authorization");

  private final String header;

  HeaderType(String header) {
    this.header = header;
  }

  public String getHeader() {
    return header;
  }
}