package core.context;

public class ContextHolder {
  private static final ThreadLocal<Context> context = ThreadLocal.withInitial(Context::new);

  public static Context getContext() {
    return context.get();
  }

  public static void removeContext() {
    context.remove();
  }
}