package core.context.ui;

public class UiContextHolder {
  private static final ThreadLocal<UiContext> uiContext = ThreadLocal.withInitial(UiContext::new);

  public static UiContext getContext() {
    return uiContext.get();
  }

  public static void removeContext() {
    uiContext.remove();
  }
}