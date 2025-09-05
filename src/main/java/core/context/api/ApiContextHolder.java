package core.context.api;

public class ApiContextHolder {
  private static final ThreadLocal<ApiContext> apiContext = ThreadLocal.withInitial(ApiContext::new);

  public static ApiContext getContext() {
    return apiContext.get();
  }

  public static void removeContext() {
    apiContext.remove();
  }
}