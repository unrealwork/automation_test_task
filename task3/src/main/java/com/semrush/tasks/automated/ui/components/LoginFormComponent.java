package com.semrush.tasks.automated.ui.components;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selectors.byName;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.config.ClientConfig;
import io.qameta.allure.Step;

/**
 * API for actions available from LoginFormComponent.
 */
public final class LoginFormComponent extends AComponent {

  /**
   * Project's configuration.
   */
  private static ClientConfig config = ClientConfig.getDefault();

  /**
   * Default constructor.
   */
  public LoginFormComponent() {
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
   * Authorize to system with default credentials.
   */
  public void authorize() {
    authorize(config.getLogin(), config.getPassword());
    new UserMenuComponent().loginButton()
        .waitUntil(not(exist), config.getActionTimeout());
  }

  /**
   * Fill email field.
   *
   * @param email - email password.
   * @return instance of {@link LoginFormComponent}.
   */
  @Step("Fill email field with value {email}")
  public LoginFormComponent fillEmail(final String email) {
    emailField().setValue(email);
    return this;
  }

  /**
   * Fill password field.
   *
   * @param password - value of password.
   * @return instance of {@link LoginFormComponent}
   */
  @Step("Fill password field with value {password}")
  public LoginFormComponent fillPassword(final String password) {
    passwordField().setValue(password);
    return this;
  }

  /**
   * Submit form data.
   */
  @Step("Click Login form submit button")
  public void submit() {
    submitButton().submit();
  }

  @Override
  public SelenideElement root() {
    return Selenide.$("div.auth-popup");
  }


  /**
   * Email field of form.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement emailField() {
    return find(byName("email"));
  }

  /**
   * Password input Element.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement passwordField() {
    return find(byName("password"));
  }

  /**
   * Button for submit loginForm form.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement submitButton() {
    return find("button.auth-form__button");
  }
}
