package com.semrush.tasks.automated.ui.components.notes;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import com.semrush.tasks.automated.ui.model.Note;


/**
 * Notes page UI API.
 */
public final class NotesComponent extends AComponent {

  @Override
  public SelenideElement root() {
    return Selenide.$("div.notes-list");
  }

  /**
   * Create passed note.
   *
   * @param note note for creation.
   */
  public void add(final Note note) {
    openAddForm().add(note);
  }

  /**
   * Open form for create component.
   *s
   * @return instance of {@link NoteCreateEditorComponent}
   */
  private NoteCreateEditorComponent openAddForm() {
    addNoteButton().click();
    return new NoteCreateEditorComponent();
  }

  /**
   * Button opening form for note creation.
   *
   * @return element of page.
   */
  private SelenideElement addNoteButton() {
    return find("button[data-cream-action=add-note]");
  }

  /**
   * @return Notes list component.
   */
  public NotesListComponent list() {
    return new NotesListComponent();
  }
}
