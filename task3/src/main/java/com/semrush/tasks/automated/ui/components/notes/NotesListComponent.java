package com.semrush.tasks.automated.ui.components.notes;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;

/**
 * List of notes UI API.
 */
public final class NotesListComponent extends AComponent {

  @Override
  public SelenideElement root() {
    return Selenide.$("div.notes-list-items-container");
  }

  /**
   * Last item list.
   *
   * @return NotesListComponent.
   */
  public NotesListItemComponent last() {
    return new NotesListItemComponent(Selenide.$$("tbody tr").get(0));
  }
}
