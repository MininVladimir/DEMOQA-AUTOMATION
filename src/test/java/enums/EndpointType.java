package enums;

public enum EndpointType {
  USER_REGISTRATION("Account/v1/User"),
  GENERATE_TOKEN("Account/v1/GenerateToken"),
  LOGIN("Account/v1/Login"),
  USER_LOGIN("Account/v1/User/");

  private final String endpoint;

  EndpointType(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getEndpoint() {
    return endpoint;
  }
}