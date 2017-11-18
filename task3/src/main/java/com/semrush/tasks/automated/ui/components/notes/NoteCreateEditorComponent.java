package com.semrush.tasks.automated.ui.components.notes;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import com.semrush.tasks.automated.ui.model.Note;

/***
 * Form for creation note.
 */
public final class NoteCreateEditorComponent extends AComponent {

  @Override
  public SelenideElement root() {
    return Selenide.$("div.notes-editor");
  }

  /**
   * Fill note's name.
   *
   * @param name of note.
   * @return NoteCreateEditorComponent.
   */
  public NoteCreateEditorComponent fillName(final String name) {
    nameInput().setValue(name);
    return this;
  }

  /**
   * Input for note's name.
   *
   * @return element of page.
   */
  private SelenideElement nameInput() {
    return find("input[data-cream-ui=input-title]");
  }

  /**
   * Add note.
   *
   * @param note note to add.
   * @return NotesComponent.
   */
  public NotesComponent add(final Note note) {
    fillName(note.getName()).save();
    return new NotesComponent();
  }

  /**
   * Save note.
   */
  public void save() {
    saveButton().click();
  }

  /**
   * Save button element.
   *
   * @return element of the page.
   */
  private SelenideElement saveButton() {
    return find("button[data-cream-action=save]");
  }
}
