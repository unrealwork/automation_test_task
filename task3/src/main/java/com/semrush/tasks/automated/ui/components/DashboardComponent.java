package com.semrush.tasks.automated.ui.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

/**
 *
 */
public final class DashboardComponent extends AComponent {

  /**
   * Open adding form on dashboard page.
   *
   * @return comonent {@link CreateProjectFormComponent}
   */
  public CreateProjectFormComponent createProject() {
    createProjectButton().click();
    return new CreateProjectFormComponent();
  }

  /**
   * Open project list dashboard page.
   *
   * @return component {@link ProjectComponent}
   */
  public ProjectComponent listProject() {
    listProjectButton().click();
    return new ProjectComponent();
  }

  /**
   * Create project button.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement createProjectButton() {
    return find("span.tn-projects__add");
  }

  /**
   * Project list button.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement listProjectButton() {
    return find("button.tn-projects__my.js-projects-search-bar-list");
  }

  @Override
  public SelenideElement root() {
    return Selenide.$("div.s-layout__content");
  }
}
