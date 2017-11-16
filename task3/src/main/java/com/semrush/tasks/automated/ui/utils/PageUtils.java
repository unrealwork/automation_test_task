package com.semrush.tasks.automated.ui.utils;

import com.codeborne.selenide.Selenide;
import com.semrush.tasks.automated.ui.config.ClientConfig;
import java.net.URL;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;

public class PageUtils {

  private static ClientConfig config = ClientConfig.getDefault();

  public static <T> T open(Class<T> clazz) {
    return open(StringUtils.EMPTY, clazz);
  }

  public static <T> T open(String pathSegment, Class<T> clazz) {
    URL url = HttpUrl.parse(config.getServer())
        .newBuilder()
        .addPathSegment(pathSegment)
        .build()
        .url();
    return Selenide.open(
        url, clazz);
  }
}
