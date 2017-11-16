package com.semrush.tasks.automated.ui.components;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

/**
 * API for actions available from LoginForm.
 */
public final class LoginForm {

  /**
   * Default constructor.
   */
  public LoginForm() {
    super();
  }

  /**
   * Authorize to system.
   *
   * @param email - user email.
   * @param password - user password.
   */
  public void authorize(final String email, final String password) {
    fillEmail(email).fillPassword(password).submit();
  }

  /**
   * Fill email field.
   *
   * @param email - email password.
   * @return instance of {@link LoginForm}.
   */
  public LoginForm fillEmail(final String email) {
    emailField().setValue(email);
    return this;
  }

  /**
   * Fill password field.
   *
   * @param password - value of password.
   * @return instance of {@link LoginForm}
   */
  public LoginForm fillPassword(final String password) {
    passwordField().setValue(password);
    return this;
  }

  /**
   * Submit form data.
   */
  public void submit() {
    submitButton().submit();
  }

  /**
   * Containter which contains all elements of form.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement container() {
    return $("div.auth-popup");
  }


  /**
   * Email field of form.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement emailField() {
    return container().$(byName("email"));
  }

  /**
   * Password input Element.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement passwordField() {
    return container().$(byName("password"));
  }

  /**
   * Button for submit loginForm form.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement submitButton() {
    return container().$("button.auth-form__button");
  }
}
