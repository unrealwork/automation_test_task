package com.semrush.tasks.automation.config;

import com.semrush.tasks.automation.utils.CommonUtils;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test client config.
 */
public final class SpaceShipServiceConfig {

  /**
   * Class' logger.
   */
  private static final Logger LOG =
      LoggerFactory.getLogger(SpaceShipServiceConfig.class);
  /**
   * Name of default configuration file stored as resource.
   */
  private static final String CLIENT_PROPERTIES = "client.properties";

  /**
   * Main property keys.
   */
  private static final class PropertyKeys {

    /**
     * Server's property key.
     */
    private static final String SERVER = "server.url";
  }

  /**
   * Configuration toolkit's instance.
   */
  private static Configurations configs = new Configurations();

  /**
   * instance of default config.
   */
  private static SpaceShipServiceConfig instance;
  /**
   * Server's URL.
   */
  private String server;


  /**
   * Default constructor hidden for safety.
   */
  private SpaceShipServiceConfig() {
  }

  /**
   * Get default instance of config.
   *
   * @return SpaceShipServiceConfig instance.
   */
  public static SpaceShipServiceConfig getDefault() {
    if (instance == null) {
      instance = new SpaceShipServiceConfig();
      try {
        instance.server = configs.properties(CLIENT_PROPERTIES)
            .getString(PropertyKeys.SERVER);
      } catch (ConfigurationException e) {
        LOG.info("Failed to load SpaceShipServiceConfig. Reason: {}",
            e.getLocalizedMessage());
        throw new IllegalStateException(e);
      }
    }
    LOG.info("SpaceShipServiceConfig was successfully loaded: {}", instance);
    return instance;
  }

  /**
   * Retrieve servers'url.
   *
   * @return String value.
   */
  public String getServer() {
    return server;
  }

  /**
   * JSON representation of config's object.
   *
   * @return JSON formatted string.
   */
  @Override
  public String toString() {
    return CommonUtils.toJson(this);
  }
}
