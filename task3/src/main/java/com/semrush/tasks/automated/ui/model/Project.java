package com.semrush.tasks.automated.ui.model;

/**
 * Project's model.
 */
public class Project {

  /**
   * Project's domain.
   */
  private String domain;
  /**
   * Project's name.
   */
  private String name;

  /**
   * Basic contructor.
   *
   * @param domainValue domain.
   * @param nameValue name.
   */
  public Project(final String domainValue, final String nameValue) {
    this.domain = domainValue;
    this.name = nameValue;
  }

  /**
   * Project's domain.
   *
   * @return String representation.
   */
  public String getDomain() {
    return domain;
  }

  /**
   * Project's name.
   *
   * @return String representation.
   */
  public String getName() {
    return name;
  }
}
