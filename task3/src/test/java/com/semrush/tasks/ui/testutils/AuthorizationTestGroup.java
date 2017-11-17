package com.semrush.tasks.ui.testutils;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;

/**
 * Methods related to Authorization Test Group.
 */
public final class AuthorizationTestGroup {

  /**
   * Logout from the system after authorized tests.
   */
  @AfterGroups(groups = {"authorized"})
  public void after() {
    AuthorizationUtils.logout();
  }

  /**
   * Login To system before authorized tests.
   */
  @BeforeGroups(groups = {"authorized"})
  public void before() {
    AuthorizationUtils.login();
  }
}
