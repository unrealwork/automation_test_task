package com.semrush.tasks.automated.ui.components;

import com.semrush.tasks.automated.ui.components.notes.NotesComponent;
import com.semrush.tasks.automated.ui.components.projects.ProjectsComponent;
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
   * ProjectsComponent Component page creation.
   *
   * @return DashboardComponent.
   */
  public static ProjectsComponent projects() {
    return PageUtils.open("projects", ProjectsComponent.class);
  }

  /**
   * Notes Component page creation.
   *
   * @return NotesComponent.
   */
  public static NotesComponent notes() {
    return PageUtils.open("notes", NotesComponent.class);
  }

  /**
   * Hidden constructor for safety.
   */
  private Components() {

  }
}
