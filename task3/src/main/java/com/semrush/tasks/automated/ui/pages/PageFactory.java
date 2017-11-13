package com.semrush.tasks.automated.ui.pages;

import com.semrush.tasks.automated.ui.utils.PageUtils;

public class PageFactory {

  public static LoginPage login() {
    return app().clickLoginButton();
  }

  public static BasePage app() {
    return PageUtils.open(BasePage.class);
  }


}
