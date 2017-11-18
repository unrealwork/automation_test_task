package com.semrush.tasks.automated.ui.components.projects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import io.qameta.allure.Step;

/**
 * Specific project Component.
 */
public final class ProjectListItemComponent extends AComponent {

  /**
   * Root element of project.
   */
  private SelenideElement rootElement;


  /**
   * Create Component from root element.
   *
   * @param element instance of {@link SelenideElement}
   */
  public ProjectListItemComponent(final SelenideElement element) {
    this.rootElement = element;
  }

  /**
   * Default constructor trying to find default root element on page.
   */
  public ProjectListItemComponent() {
    rootElement = Selenide.$("div.pr-page__list__project");
  }

  @Override
  public SelenideElement root() {
    return rootElement;
  }

  /**
   * Settings button.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement settingsButton() {
    return find("div.sr-infomenu.border.left.js-toggle");
  }

  /**
   * Open project settings.
   *
   * @return project's settings.
   */
  @Step("Open project's settings")
  public ProjectSettingsComponent openSettings() {
    settingsButton().click();
    return new ProjectSettingsComponent();
  }
}
