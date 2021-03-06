package com.semrush.tasks.automated.ui.components.projects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import io.qameta.allure.Step;

/**
 * Project Remove dialog UI API.
 */
public class ProjectRemoveDialogComponent extends AComponent {

  /**
   * Root element.
   *
   * @return instance of root element.
   */
  @Override
  public SelenideElement root() {
    return Selenide.$("div.pr-dialog.-delete");
  }

  /**
   * Confirm dialog button.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement confirmButton() {
    return find("button.js-remove");
  }

  /**
   * Input to verify project which will be removed element.
   *
   * @return page element.
   */
  public SelenideElement confirmInput() {
    return find("input.s-input__control.js-remove-input");
  }

  /**
   * Name of the project will be removed element.
   *
   * @return page element.
   */
  public SelenideElement projectNameText() {
    return find("p.pr-dialog-attention.s-color.-danger");
  }

  /**
   * Remove the project.
   *
   * @return Project List Component.
   */
  @Step("Copy project name and insert to field for confirm. Then confirm form.")
  public ProjectsComponent remove() {
    confirmInput().setValue(projectNameText().getText());
    confirmButton().click();

    ProjectsComponent component = new ProjectsComponent();
    return component;
  }

}
