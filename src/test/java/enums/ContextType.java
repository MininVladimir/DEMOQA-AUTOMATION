package enums;

public enum ContextType {
  API("api"),
  UI("ui");

  private final String contextType;

  ContextType(String contextType) {
    this.contextType = contextType;
  }

  public String getContextType() {
    return contextType;
  }
}