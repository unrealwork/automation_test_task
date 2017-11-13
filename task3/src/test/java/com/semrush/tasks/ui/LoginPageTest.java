package com.semrush.tasks.ui;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.semrush.tasks.automated.ui.config.ClientConfig;
import com.semrush.tasks.automated.ui.pages.LoginPage;
import com.semrush.tasks.automated.ui.pages.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginPageTest {

  @Test(description = "Test login to the site through the main page")
  public void testLogin() {
    final ClientConfig config = ClientConfig.getDefault();
    LoginPage loginPage = PageFactory.login();
    loginPage.authorize(config.getLogin(), config.getPassword());
    WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
    wait.until(ExpectedConditions.urlMatches("dashboard"));
  }
}
