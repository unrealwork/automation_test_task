package com.semrush.tasks.automated.ui.pages;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private final WebDriver driver;
  private SelenideElement emailField = $(byName("email"));
  private SelenideElement passwordField = $(byName("password"));
  private SelenideElement submitButton = $("button.auth-form__button");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void authorize(String email, String password) {
    fillEmail(email).fillPassword(email).submit();
  }

  public LoginPage fillEmail(String email) {
    emailField.click();
    emailField.setValue(email);
    return this;
  }


  public LoginPage fillPassword(String password) {
    passwordField.click();
    passwordField.sendKeys(password);
    return this;
  }

  public void submit() {
    submitButton.submit();
  }
}