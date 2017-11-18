package com.semrush.tasks.ui.testutils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Fail tests listener.
 */
public class ScreenshotAttachListener implements IInvokedMethodListener {

  /**
   * Class' logger.
   */
  private static final Logger LOG = LoggerFactory
      .getLogger(ScreenshotAttachListener.class);

  @Override
  public void beforeInvocation(final IInvokedMethod method,
      final ITestResult testResult) {
  }

  /**
   * Handel after invocation.
   *
   * @param method method
   * @param testResult result of test.
   */
  @Override
  public void afterInvocation(final IInvokedMethod method,
      final ITestResult testResult) {
    if (method.isTestMethod() && !testResult.isSuccess()) {
      attachScreenshot(method.getTestMethod().getMethodName());
    }
  }

  /**
   * Attach screenshot to allure.
   *
   * @param methodName name of invoked method.
   */
  private void attachScreenshot(final String methodName) {
    try {
      Allure.addAttachment(MessageFormat.format("Screenshot{0}", methodName),
          new ByteArrayInputStream(FileUtils
              .readFileToByteArray(Screenshots.takeScreenShotAsFile())));
    } catch (IOException e) {
      LOG.warn("Failed to attach screenshot to test");
      e.printStackTrace();
    }
  }
}

