package com.semrush.tasks.ui.dashboard;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.Components;
import com.semrush.tasks.automated.ui.components.projects.ProjectCreateFormComponent;
import com.semrush.tasks.automated.ui.components.projects.ProjectsComponent;
import com.semrush.tasks.automated.ui.config.ClientConfig;
import com.semrush.tasks.automated.ui.model.Project;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * DashboardComponent component's tests.
 */
@Test(groups = {"authorized"})
public class DashboardComponentTest {

  /**
   * Tests project's creating procedure with valid data.
   */
  @Test(description = "Tests project's creating procedure with valid data")
  public void testAddProject() {
    ProjectCreateFormComponent addingForm = Components.dashboard()
        .createProject();
    addingForm.add(new Project("google.com", "a"));
    final ClientConfig config = ClientConfig.getDefault();
    SelenideElement root = new ProjectsComponent().root();
    root.waitUntil(visible.because(
        "We should be redirected to projects page"
    ), config.getActionTimeout());
  }


  /**
   * Clean up data.
   */
  @AfterMethod
  @BeforeMethod
  public void cleanProjects() {
    Components.projects().list().clear();
  }
}
