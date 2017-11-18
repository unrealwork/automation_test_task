package com.semrush.tasks.ui.dashboard;

import com.semrush.tasks.automated.ui.model.Project;
import org.testng.annotations.DataProvider;

/**
 * Provide data for dashboard component testing.
 */
public final class DashboardComponentProvider {

  /**
   * Provides projects for creation.
   *
   * @return array of projects, test params.
   */
  @DataProvider(name = "projectsProvider")
  public static Object[][] provideProjects() {
    return new Object[][]{
        {new Project("google.com", "a")}
    };
  }

  /**
   * Hidden for safety.
   */
  private DashboardComponentProvider() {
  }
}
