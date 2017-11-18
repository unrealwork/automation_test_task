package com.semrush.tasks.automated.ui.components.projects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import io.qameta.allure.Step;

/**
 * API for projects settings.
 */
public final class ProjectSettingsComponent extends AComponent {

  @Override
  public SelenideElement root() {
    return Selenide.$("div.sr-infomenu-content-wrapper");
  }

  /**
   * Remove button.
   *
   * @return remove dialog component.
   */
  @Step("Select remove option.")
  public ProjectRemoveDialogComponent removeDialog() {
    removeLink().click();
    return new ProjectRemoveDialogComponent();
  }


  /**
   * Remove project button.
   *
   * @return remove project.
   */
  public SelenideElement removeLink() {
    return find("a.js-remove");
  }
}
