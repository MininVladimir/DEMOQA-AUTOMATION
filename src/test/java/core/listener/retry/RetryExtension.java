package core.listener.retry;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryExtension implements TestExecutionExceptionHandler, BeforeTestExecutionCallback {
  private final AtomicInteger retryCount = new AtomicInteger(0);

  @Override
  public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
    int maxRetries = 2;
    if (retryCount.incrementAndGet() <= maxRetries) {
      Allure.step("[Retry] Attempt #" + retryCount.get());
      try {
        context.getRequiredTestMethod().invoke(context.getRequiredTestInstance());
      } catch (InvocationTargetException ite) {
        Throwable cause = ite.getCause();
        if (retryCount.get() == maxRetries) {
          throw cause;
        }
        handleTestExecutionException(context, cause);
      }
    } else {
      throw throwable;
    }
  }

  @Override
  public void beforeTestExecution(ExtensionContext context) {
    retryCount.set(0);
  }
}