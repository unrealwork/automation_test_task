package com.semrush.tasks.automated.ui.components;

import com.semrush.tasks.automated.ui.utils.PageUtils;


/**
 * Factory for main components of SEMrush UI.
 */
public final class Components {

  /**
   * Load user menu.
   *
   * @return instance of {@link UserMenuComponent}.
   */
  public static UserMenuComponent userMenu() {
    return PageUtils.open(UserMenuComponent.class);
  }


  /**
   * Load login form.
   *
   * @return instance of {@link LoginFormComponent}.
   */
  public static LoginFormComponent loginForm() {
    return userMenu().loginForm();
  }

  /**
   * DashboardComponent page creation.
   *
   * @return DashboardComponent.
   */
  public static DashboardComponent dashboard() {
    return PageUtils.open("dashboard", DashboardComponent.class);
  }

  /**
   * Hidden constructor for safety.
   */
  private Components() {

  }
}
