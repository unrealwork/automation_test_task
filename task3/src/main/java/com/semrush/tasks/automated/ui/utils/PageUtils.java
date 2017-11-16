package com.semrush.tasks.automated.ui.utils;

import com.codeborne.selenide.Selenide;
import com.semrush.tasks.automated.ui.config.ClientConfig;
import java.net.URL;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.StringUtils;

/**
 * Utility methods for page manipulation.
 */
public final class PageUtils {

  /**
   * Project's configuration.
   */
  private static ClientConfig config = ClientConfig.getDefault();


  /**
   * Create PageObject on index page.
   *
   * @param clazz PageObject class.
   * @param <T> Type of return.
   * @return instance of page object.
   */
  public static <T> T open(final Class<T> clazz) {
    return open(StringUtils.EMPTY, clazz);
  }

  /**
   * Crete PageObject on specific path.
   *
   * @param pathSegment - path.
   * @param clazz - PageObject class.
   * @param <T> Type of return.
   * @return instance of page object.
   */
  public static <T> T open(final String pathSegment, final Class<T> clazz) {
    URL url = HttpUrl.parse(config.getServer())
        .newBuilder()
        .addPathSegment(pathSegment)
        .build()
        .url();
    return Selenide.open(
        url, clazz);
  }


  /**
   * Hidden constructor.
   */
  private PageUtils() {

  }
}
