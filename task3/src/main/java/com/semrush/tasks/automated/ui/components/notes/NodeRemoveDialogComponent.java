package com.semrush.tasks.automated.ui.components.notes;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import io.qameta.allure.Step;

/**
 * Note Remove Dialog.
 */
public final class NodeRemoveDialogComponent extends AComponent {

  @Override
  public SelenideElement root() {
    return $("div.notes-dialog");
  }

  /**
   * Confirm removing.
   */
  @Step("Click confirm button")
  public void confirm() {
    $("button[data-cream-action=delete]").click();
  }
}
