package com.semrush.tasks.automation.api.utils;

import static java.util.Optional.ofNullable;

import com.semrush.tasks.automation.config.SpaceShipServiceConfig;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Listener that add environmental info to allure results.
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
   * Add environment info after all test execution.
   *
   * @param iTestContext context.
   */
  @Override
  public void onFinish(final ITestContext iTestContext) {
    final SpaceShipServiceConfig config = SpaceShipServiceConfig.getDefault();
    try (FileOutputStream fos = new FileOutputStream(
        "target/allure-results/environment.properties")) {
      Properties props = new Properties();

      ofNullable(config.getServer())
          .ifPresent(s -> props.setProperty("Site URL", s));
      props.store(fos,
          "Environment properties");
    } catch (IOException e) {
      LOG.error("IO problem when writing allure properties file", e);
    }
  }
}
