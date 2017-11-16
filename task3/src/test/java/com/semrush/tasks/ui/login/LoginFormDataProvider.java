package com.semrush.tasks.ui.login;

import com.semrush.tasks.automated.ui.config.ClientConfig;
import org.testng.annotations.DataProvider;

/**
 * Contains sets of data for tests from {@link LoginFormTest}.
 */
public final class LoginFormDataProvider {

  /**
   * Configuration of project.
   */
  private static ClientConfig clientConfig = ClientConfig.getDefault();

  /**
   * Different credentials.
   *
   * @return array of params.
   */
  @DataProvider(name = "credentialsProvider")
  public static Object[][] credentialsProvider() {
    return new Object[][]{
        {clientConfig.getLogin(), clientConfig.getPassword()}
    };
  }

  /**
   * Hide constructor for safety.
   */
  private LoginFormDataProvider() {
  }
}
