package com.semrush.tasks.automated.ui.components.projects;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.AComponent;
import com.semrush.tasks.automated.ui.model.Project;

/**
 * Form for create Project.
 */
public final class ProjectCreateFormComponent extends AComponent {

  /**
   * Domain field' element.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement domainField() {
    return find("input.js-pr-watch-domain");
  }


  /**
   * Name field' element.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement nameField() {
    return find("input.js-pr-watch-name");
  }


  /**
   * Submit button of Form.
   *
   * @return instance of {@link SelenideElement}
   */
  public SelenideElement submitButton() {
    return find("span.s-btn__text");
  }


  @Override
  public SelenideElement root() {
    return Selenide.$("div.js-pr-form-container.temp-tn-projects__form_wrap");
  }

  /**
   * Fill name field.
   *
   * @param name name of project.
   * @return this component;
   */
  public ProjectCreateFormComponent fillName(final String name) {
    nameField().setValue(name);
    return this;
  }


  /**
   * Fill domain field.
   *
   * @param domain name of project.
   * @return this component;
   */
  public ProjectCreateFormComponent fillDomain(final String domain) {
    domainField().setValue(domain);
    return this;
  }

  /**
   * Submit create button.
   */
  public void submit() {
    submitButton().click();
  }

  /**
   * Add project.
   *
   * @param project model instance.
   */
  public void add(final Project project) {
    fillDomain(project.getDomain()).fillName(project.getName()).submit();
  }
}