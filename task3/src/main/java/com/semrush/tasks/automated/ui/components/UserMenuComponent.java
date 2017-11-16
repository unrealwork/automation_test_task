package com.semrush.tasks.automated.ui.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * API of user menu.
 */
public class UserMenuComponent {

  /**
   * Logger for this class.
   */
  private static final Logger LOG = LoggerFactory
      .getLogger(UserMenuComponent.class);

  /**
   * css selector for loginButton.
   */
  private static final String LOGIN_BUTTON_SELECTOR =
      "button.js-authentication-login";


  /**
   * Container that contains menu.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement container() {
    return $("div.header");
  }


  /**
   * Login button.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement loginButton() {
    return $(LOGIN_BUTTON_SELECTOR);
  }

  /**
   * Is user authorized.
   *
   * @return true if authorized
   */
  public boolean isAurhorized() {
    return !loginButton().isEnabled();
  }

  /**
   * Login form.
   *
   * @return instance of LoginFormComponent.
   */
  public LoginFormComponent loginForm() {
    loginButton().click();
    return new LoginFormComponent();
  }
}
