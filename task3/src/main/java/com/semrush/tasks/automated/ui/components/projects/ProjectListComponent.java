package com.semrush.tasks.automated.ui.components.projects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Project list().
 */
public final class ProjectListComponent extends AComponent {

  @Override
  public SelenideElement root() {
    return Selenide.$("js-projects-list");
  }

  /**
   * List of {@link ProjectListItemComponent}.
   *
   * @return list of components.
   */
  public List<ProjectListItemComponent> items() {
    return itemsElements().stream()
        .map(ProjectListItemComponent::new).collect(
            Collectors.toList());
  }

  /**
   * Page elements containing items.
   *
   * @return page elements.
   */
  public ElementsCollection itemsElements() {
    return Selenide.$$("div.pr-page__list__project");
  }

  /**
   * Clear projects list.
   *
   * @return ProjectListComponent.
   */
  @Step("Remove each elements in the list.")
  public ProjectListComponent clear() {
    items().forEach(projectListItemComponent -> {
      projectListItemComponent
          .openSettings()
          .removeDialog()
          .remove();
    });
    return this;
  }
}
