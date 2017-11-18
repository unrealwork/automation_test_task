package com.semrush.tasks.automated.ui.components.notes;

import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;

/**
 * Notes List's item component.
 */
public final class NotesListItemComponent extends AComponent {

  /**
   * Root element.
   */
  private SelenideElement rootElement;

  /**
   * Constructor from page element.
   *
   * @param element element of page.
   */
  public NotesListItemComponent(final
  SelenideElement element) {
    this.rootElement = element;
  }

  @Override
  public SelenideElement root() {
    return rootElement;
  }

  /**
   * remove an Item.
   */
  public void remove() {
    openSettings().remove();
  }

  /**
   * Open  item's settings.
   *
   * @return NoteItemSettingsComponent.
   */
  private NoteItemSettingsComponent openSettings() {
    settingsItem().click();
    return new NoteItemSettingsComponent();
  }

  /**
   * Setting's page item.
   *
   * @return element of page.
   */
  private SelenideElement settingsItem() {
    return find("div[data-cream-region=settings]");
  }

  /**
   * Note cell.
   *
   * @return element of page.
   */
  public SelenideElement noteCell() {
    return find("td[data-cream-column-id=note]");
  }

  /**
   * Name of the note stored in Component.
   *
   * @return name of note.
   */
  public SelenideElement nameElement() {
    return noteCell().$("span.notes-note-title");
  }
}
