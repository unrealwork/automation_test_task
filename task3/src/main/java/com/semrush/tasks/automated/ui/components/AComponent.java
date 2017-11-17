package com.semrush.tasks.automated.ui.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

/**
 * Abastract site UI component.
 */
public abstract class AComponent {

  /**
   * Root element.
   *
   * @return instance of {@link SelenideElement}
   */
  public abstract SelenideElement root();

  /**
   * Find element inside component.
   *
   * @param cssSelector СSS selector.
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement find(final String cssSelector) {
    return root().$(cssSelector);
  }

  /**
   * Find element inside component.
   *
   * @param by By selector.
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement find(final By by) {
    return root().$(by);
  }
}
