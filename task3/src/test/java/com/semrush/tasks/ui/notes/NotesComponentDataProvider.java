package com.semrush.tasks.ui.notes;

import com.semrush.tasks.automated.ui.model.Note;
import org.testng.annotations.DataProvider;

/**
 * Provided different data for testing notes component.
 */
public final class NotesComponentDataProvider {

  /**
   * Provides notes for creation.
   *
   * @return array of notes.
   */
  @DataProvider(name = "notesProvider")
  public static Object[][] provideNotes() {
    return new Object[][]{
        {new Note("cool")}
    };
  }


  /**
   * Hide constructor for safety.
   */
  private NotesComponentDataProvider() {

  }
}
