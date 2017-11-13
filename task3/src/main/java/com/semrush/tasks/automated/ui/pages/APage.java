package com.semrush.tasks.automated.ui.pages;

import org.openqa.selenium.WebDriver;

public class APage {

  private WebDriver webDriver;

  public APage() {
  }

  public APage(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

  public String getTitle() {
    return getWebDriver().getTitle();
  }
}
