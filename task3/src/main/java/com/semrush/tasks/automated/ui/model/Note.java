package com.semrush.tasks.automated.ui.model;

import com.semrush.tasks.automated.ui.utils.CommonUtils;

/**
 * Model for note. Contains only required fields.
 */
public class Note {

  /**
   * Name of the note.
   */
  private String name;

  /**
   * Create note.
   *
   * @param noteName name of note.
   */
  public Note(final String noteName) {
    this.name = noteName;
  }

  /**
   * Unnecessary constructor.
   */
  private Note() {
  }

  /**
   * Retrieve name of note.
   *
   * @return name of note.
   */
  public String getName() {
    return name;
  }

  /**
   * JSON representation of Note.
   *
   * @return JSON.
   */
  @Override
  public String toString() {
    return CommonUtils.toJson(this);
  }
}
