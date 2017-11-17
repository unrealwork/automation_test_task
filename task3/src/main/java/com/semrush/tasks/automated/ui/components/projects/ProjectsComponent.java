package com.semrush.tasks.automated.ui.components.projects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;

/**
 * ProjectsComponent main component.
 */
public class ProjectsComponent extends AComponent {

  /**
   * ProjectsComponent main component element.
   *
   * @return root element of component.
   */
  @Override
  public SelenideElement root() {
    return Selenide.$("div.pr-main");
  }

  /**
   * Proejct list.
   *
   * @return List of projects Component.
   */
  public ProjectListComponent list() {
    return new ProjectListComponent();
  }
}
