package com.semrush.tasks.automated.ui.components;

import com.semrush.tasks.automated.ui.utils.PageUtils;


/**
 * Factory for main components of SEMrush UI.
 */
public final class Components {

  /**
   * Load user menu.
   *
   * @return instance of {@link UserMenu}.
   */
  public static UserMenu userMenu() {
    return PageUtils.open(UserMenu.class);
  }


  /**
   * Load login form.
   *
   * @return instance of {@link LoginForm}.
   */
  public static LoginForm loginForm() {
    return userMenu().loginForm();
  }

  /**
   * Hidden constructor for safety.
   */
  private Components() {

  }
}
