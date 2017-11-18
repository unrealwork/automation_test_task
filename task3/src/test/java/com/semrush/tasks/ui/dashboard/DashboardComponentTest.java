package com.semrush.tasks.ui.dashboard;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;
import com.semrush.tasks.automated.ui.components.Components;
import com.semrush.tasks.automated.ui.components.projects.ProjectCreateFormComponent;
import com.semrush.tasks.automated.ui.components.projects.ProjectsComponent;
import com.semrush.tasks.automated.ui.config.ClientConfig;
import com.semrush.tasks.automated.ui.model.Project;
import com.semrush.tasks.ui.testutils.AuthorizationUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * DashboardComponent component's tests.
 */
public class DashboardComponentTest {

  /**
   * Tests project's creating procedure with valid data.
   *
   * @param project project to add.s
   */

  @Feature("Project")
  @Story("Add new project.")
  @Test(description = "Tests project's creating procedure with valid data",
      dataProviderClass = DashboardComponentProvider.class,
      dataProvider = "projectsProvider",
      groups = {"authorized"}
  )
  public void testAddProject(final Project project) {
    ProjectCreateFormComponent addingForm = Components.dashboard()
        .createProject();
    addingForm.add(project);
    final ClientConfig config = ClientConfig.getDefault();
    SelenideElement root = new ProjectsComponent().root();
    root.waitUntil(visible.because(
        "We should be redirected to projects page"
    ), config.getActionTimeout());
  }

  /**
   * Set up.
   */
  @BeforeMethod(description = "Login to system and clear projects list.",
      groups = {"authorized"})
  public void setUp() {
    AuthorizationUtils.login();
    Components.projects().list().clear();
  }

  /**
   * Clean up data.
   */
  @AfterMethod(description = "Clear project's list and logout",
      groups = {"authorized"})
  public void tearDown() {
    Components.projects().list().clear();
    AuthorizationUtils.logout();
  }
}
