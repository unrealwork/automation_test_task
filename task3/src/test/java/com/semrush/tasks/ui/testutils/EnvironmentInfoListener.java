package com.semrush.tasks.ui.testutils;

import static java.util.Optional.ofNullable;

import com.codeborne.selenide.Configuration;
import com.semrush.tasks.automated.ui.config.ClientConfig;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Create file for allure tests about test environment.
 */
public class EnvironmentInfoListener implements ITestListener {

  /**
   * Class logger.
   */
  private static final Logger LOG = LoggerFactory
      .getLogger(EnvironmentInfoListener.class);

  @Override
  public void onTestStart(final ITestResult iTestResult) {

  }

  @Override
  public void onTestSuccess(final ITestResult iTestResult) {

  }

  @Override
  public void onTestFailure(final ITestResult iTestResult) {

  }

  @Override
  public void onTestSkipped(final ITestResult iTestResult) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(
      final ITestResult iTestResult) {

  }

  @Override
  public void onStart(final ITestContext iTestContext) {

  }

  /**
   * Generate environment info after test.
   *
   * @param iTestContext context of test.
   */
  @Override
  public void onFinish(final ITestContext iTestContext) {
    final ClientConfig config = ClientConfig.getDefault();
    try (FileOutputStream fos = new FileOutputStream(
        "target/allure-results/environment.properties")) {
      Properties props = new Properties();

      ofNullable(Configuration.browser)
          .ifPresent(s -> props.setProperty("Browser", s));
      ofNullable(config.getServer())
          .ifPresent(s -> props.setProperty("Site URL", s));
      ofNullable(config.getLogin())
          .ifPresent(s -> props.setProperty("User email", s));
      props.store(fos,
          "Environment properties");
    } catch (IOException e) {
      LOG.error("IO problem when writing allure properties file", e);
    }
  }
}
