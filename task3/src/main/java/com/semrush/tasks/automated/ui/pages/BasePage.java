package com.semrush.tasks.automated.ui.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends APage {

  private static final String LOGIN_BUTTON_SELECTOR = "button.js-authentication-login";
  private WebDriver driver;
  private Logger LOG = LoggerFactory.getLogger(BasePage.class);
  private SelenideElement loginButton = $(LOGIN_BUTTON_SELECTOR);

  public BasePage() {
  }


  public LoginPage clickLoginButton() {
    LOG.info("Clicking on sign in button");
    if (loginButton.isDisplayed() || loginButton.isEnabled()) {
      loginButton.click();
    } else {
      String errorMessage = "Sign in button not found";
      LOG.error(errorMessage);
      throw new IllegalStateException(errorMessage);
    }
    return new LoginPage(driver);
  }

  public SelenideElement getLoginButton() {
    return loginButton;
  }
}
