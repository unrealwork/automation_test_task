package com.semrush.tasks.ui.notes;


import com.codeborne.selenide.Condition;
import com.semrush.tasks.automated.ui.components.Components;
import com.semrush.tasks.automated.ui.components.notes.NotesComponent;
import com.semrush.tasks.automated.ui.model.Note;
import com.semrush.tasks.ui.testutils.AuthorizationUtils;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests for notes component.
 */
public class NotesComponentTest {

  /**
   * Tests creation of a new note.
   *
   * @param note note to test.
   */
  @Test(description = "Tests creation of a new note",
      dataProviderClass = NotesComponentDataProvider.class,
      groups = {" authorized"},
      dataProvider = "notesProvider")
  public void testAddNote(final Note note) {
    //Action
    final NotesComponent notes = Components.notes();
    notes.add(note);
    //Assert
    final String assertMessage = MessageFormat.format(
        "Last note should have the same name as added note {0}",
        note);

    notes.list().last().nameElement().shouldBe(
        Condition.text(note.getName()).because(assertMessage));

  }

  /**
   * Set up.
   */
  @BeforeMethod(groups = {"authorized"})
  public void setUp() {
    AuthorizationUtils.login();
  }

  /**
   * Clean up data.
   *
   * @param method - test method.
   */
  @AfterMethod(groups = {"authorized"})
  public void tearDown(final Method method) {
    if ("testAddNote".equals(method.getName())) {
      Components.notes().list().last().remove();
    }
    AuthorizationUtils.logout();
  }
}
