package com.semrush.tasks.ui.dashboard;

import static com.codeborne.selenide.Condition.exist;

import com.semrush.tasks.automated.ui.components.Components;
import com.semrush.tasks.automated.ui.components.CreateProjectFormComponent;
import com.semrush.tasks.automated.ui.components.ProjectComponent;
import com.semrush.tasks.automated.ui.config.ClientConfig;
import com.semrush.tasks.automated.ui.model.Project;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * DashboardComponent component's tests.
 */
public class DashboardTest {

  /**
   * Prepare test environment.
   */
  @BeforeTest
  public void setUp() {
    Components.loginForm().authorize();
  }

  /**
   * Tests project's creating procedure with valid data.
   */
  @Test(description = "Tests project's creating procedure with valid data")
  public void testAddProject() {
    CreateProjectFormComponent addingForm = Components.dashboard()
        .createProject();
    addingForm.add(new Project("google.com", "a"));
    final ClientConfig config = ClientConfig.getDefault();
    new ProjectComponent().root()
        .waitUntil(
            exist.because("Should be redirected to created project page"),
            config.getActionTimeout());
  }
}
