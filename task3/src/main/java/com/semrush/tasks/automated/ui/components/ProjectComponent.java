package com.semrush.tasks.automated.ui.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

/**
 * Specific project Component.
 */
public final class ProjectComponent extends AComponent {

  @Override
  public SelenideElement root() {
    return Selenide.$("div.pr-main");
  }
}
