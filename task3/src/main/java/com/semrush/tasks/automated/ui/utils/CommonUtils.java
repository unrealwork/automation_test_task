package com.semrush.tasks.automated.ui.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common utils.
 */
public final class CommonUtils {

  /**
   * Logger for this instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);
  /**
   * Jackson Mapper.
   */
  private static ObjectMapper mapper = new ObjectMapper();

  /**
   * Hidden default constructor for safety.
   */
  private CommonUtils() {

  }

  /**
   * Get JSON formatted string representation of some classes.
   *
   * @param value - object instance
   * @param <T> - any class.
   * @return - JSON formatted string.
   */
  public static <T> String toJson(final T value) {
    try {
      return mapper.writeValueAsString(value);
    } catch (JsonProcessingException e) {
      LOG.error("Failed to deserialize value to JSON");
      throw new IllegalStateException(e);
    }
  }
}
