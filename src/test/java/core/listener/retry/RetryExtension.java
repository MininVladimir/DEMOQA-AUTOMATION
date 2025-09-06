package core.listener.retry;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryExtension implements TestExecutionExceptionHandler, BeforeTestExecutionCallback {
  private final AtomicInteger retryCount = new AtomicInteger(0);

  public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
    int maxRetries = 2;
    if (retryCount.incrementAndGet() <= maxRetries) {
      Allure.step("[Retry] Attempt #" + retryCount.get(), () -> {
      });
      Method testMethod = context.getRequiredTestMethod();
      Object testInstance = context.getRequiredTestInstance();
      try {
        testMethod.invoke(testInstance);
      } catch (Throwable t) {
        if (retryCount.get() == maxRetries) {
          throw t.getCause();
        } else {
          handleTestExecutionException(context, t);
        }
      }
    } else {
      throw throwable;
    }
  }

  public void beforeTestExecution(ExtensionContext context) {
    retryCount.set(0);
  }
}