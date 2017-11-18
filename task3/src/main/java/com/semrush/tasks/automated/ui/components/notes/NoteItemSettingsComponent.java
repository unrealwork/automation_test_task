package com.semrush.tasks.automated.ui.components.notes;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import io.qameta.allure.Step;

/**
 * Note's item settings.
 */
public final class NoteItemSettingsComponent extends AComponent {

  /**
   * Remove current item.
   */
  @Step("Confirm note removing")
  public void remove() {
    removeDialog().confirm();
  }

  @Override
  public SelenideElement root() {
    return Selenide.$("div.cream-settings-dropdown-view");
  }


  /**
   * Remove page element.
   *
   * @return page element.
   */
  private SelenideElement removeItem() {
    return find("div[data-cream-value=delete]");
  }

  /**
   * Open remove dialog.
   *
   * @return NodeRemoveDialogComponent.
   */
  public NodeRemoveDialogComponent removeDialog() {
    removeItem().click();
    return new NodeRemoveDialogComponent();
  }
}
