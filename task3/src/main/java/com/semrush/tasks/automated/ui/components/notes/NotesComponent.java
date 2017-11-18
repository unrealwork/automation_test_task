package com.semrush.tasks.automated.ui.components.notes;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import com.semrush.tasks.automated.ui.model.Note;
import io.qameta.allure.Step;


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
   * @return this instance.
   */
  @Step("Add new note to list")
  public NotesComponent add(final Note note) {
    openAddForm().add(note);
    return this;
  }

  /**
   * Open form for create component. s
   *
   * @return instance of {@link NoteCreateEditorComponent}
   */
  @Step("Open editor for note creation")
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
