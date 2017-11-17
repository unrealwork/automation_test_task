package com.semrush.tasks.ui.login;


import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;

import com.semrush.tasks.automated.ui.components.Components;
import com.semrush.tasks.automated.ui.components.UserMenuComponent;
import com.semrush.tasks.automated.ui.config.ClientConfig;
import com.semrush.tasks.ui.testutils.AuthorizationUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Contains tests for loginForm form behaviour.
 */
@Test(groups = {"unauthorized"})
public class LoginFormComponentTest {

  /**
   *
   */
  private static ClientConfig config = ClientConfig.getDefault();

  /**
   * Test loginForm with different credentials.
   *
   * @param login - user's loginForm.
   * @param password - user's password.
   */
  @Test(description = "Test loginForm to the site through the main page",
      dataProviderClass = LoginFormDataProvider.class,
      dataProvider = "credentialsProvider")
  public void testLogin(final String login, final String password) {
    UserMenuComponent userMenu = Components.userMenu();
    //Action
    userMenu
        .loginForm()
        .authorize(login, password);
    //Assert
    userMenu.loginButton().waitUntil(not(exist)
            .because("The user menu should be turned into authorized mode"),
        config.getActionTimeout());
  }

  /**
   * Clean authorization.
   */
  @BeforeMethod
  @AfterMethod
  public void cleanAuthorization() {
    AuthorizationUtils.logout();
  }
}
