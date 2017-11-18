package com.semrush.tasks.automated.ui.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * API of user menu.
 */
public class UserMenuComponent extends AComponent {

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
  @Override
  public SelenideElement root() {
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
  @Step("Open Login form")
  public LoginFormComponent loginForm() {
    loginButton().click();
    LoginFormComponent loginForm = new LoginFormComponent();
    loginForm.root().shouldBe(visible.because("Form container should be open"));
    return loginForm;
  }

  /**
   * Open menu.
   *
   * @return this instance.
   */
  public UserMenuComponent open() {
    toggleElement().click();
    return this;
  }

  /**
   * Log out.
   */

  public void logout() {
    open().logoutItem().click();
  }

  /**
   * Logout item of menu.
   *
   * @return page element.
   */
  private SelenideElement logoutItem() {
    return find("a[data-test=header-menu__user-logout]");
  }

  /**
   * Toggle user menu.
   *
   * @return page element.
   */
  private SelenideElement toggleElement() {
    return find("div[data-js-dropdown-toggle=-open]");
  }
}
