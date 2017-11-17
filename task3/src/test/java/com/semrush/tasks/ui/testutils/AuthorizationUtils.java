package com.semrush.tasks.ui.testutils;

import com.codeborne.selenide.Selenide;
import com.semrush.tasks.automated.ui.components.Components;

/**
 * Utilities related to user authorization.
 */
public final class AuthorizationUtils {

  /**
   * Log in to the system.
   */
  public static void login() {
    Components.loginForm().authorize();
  }


  /**
   * Hides unnecessary constructor.
   */
  private AuthorizationUtils() {
  }

  /**
   * Log out from system.
   */
  public static void logout() {
    Selenide.clearBrowserCookies();
    Selenide.clearBrowserLocalStorage();
  }
}
