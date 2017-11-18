package com.semrush.tasks.ui.login;


import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.Selenide;
import com.semrush.tasks.automated.ui.components.Components;
import com.semrush.tasks.automated.ui.components.UserMenuComponent;
import com.semrush.tasks.automated.ui.config.ClientConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Contains tests for loginForm form behaviour.
 */
public class LoginFormComponentTest {

  /**
   *
   */
  private static ClientConfig config = ClientConfig.getDefault();

  /**
   *
   */
  @Feature("Authorization")
  @Story("Login as user.")
  @Step("Open Login From.")
  public void openLoginForm() {
    Components.userMenu().loginForm()
        .root()
        .shouldBe(visible.because("Login form should appear after click"));
  }

  /**
   * Test loginForm with different credentials.
   *
   * @param login - user's loginForm.
   * @param password - user's password.
   */
  @Feature("Authorization")
  @Story("Login as user.")
  @Flaky
  @Test(description = "Test loginForm to the site through the main page",
      dataProviderClass = LoginFormDataProvider.class,
      dataProvider = "credentialsProvider",
      groups = {"authentication"})
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
   * Clean cookie before each test.
   */
  @BeforeMethod(description = "Clear browser cookie", groups = {
      "authentication"})
  @AfterClass(description = "Clear browser cookie", groups = {"authentication"})
  public void setUp() {
    Selenide.clearBrowserCookies();
  }
}
