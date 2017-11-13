package com.semrush.tasks.automated.ui.config;

import com.semrush.tasks.automated.ui.utils.CommonUtils;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientConfig {

  /**
   * Class' logger.
   */
  private static final Logger LOG =
      LoggerFactory.getLogger(ClientConfig.class);
  /**
   * Name of default configuration file stored as resource.
   */
  private static final String CLIENT_PROPERTIES = "client.properties";
  /**
   * Configuration toolkit's instance.
   */
  private static Configurations configs = new Configurations();
  /**
   * instance of default config.
   */
  private static ClientConfig instance;
  /**
   * Login for testing.
   */
  private String login;

  /**
   * Password for testing.
   */
  private String password;
  /**
   * Server's URL.
   */
  private String server;

  /**
   * Default constructor hidden for safety.
   */
  private ClientConfig() {
  }

  /**
   * Get default instance of config.
   *
   * @return ClientConfig instance.
   */
  public static ClientConfig getDefault() {
    if (instance == null) {
      instance = new ClientConfig();
      instance.server = getProperty(PropertyKeys.SERVER);
      instance.login = getProperty(PropertyKeys.LOGIN);
      instance.password = getProperty(PropertyKeys.PASSWORD);
    }
    LOG.info("SpaceShipServiceConfig was successfully loaded: {}", instance);
    return instance;
  }


  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  /**
   * Retrieve servers'url.
   *
   * @return String value.
   */
  public String getServer() {
    return server;
  }

  private static String getProperty(PropertyKeys propertyKey) {
    final String property = System.getProperty(propertyKey.key);
    if (property == null) {
      try {
        PropertiesConfiguration clientProperties = configs.properties(CLIENT_PROPERTIES);
        return clientProperties.getString(propertyKey.key);

      } catch (ConfigurationException e) {
        LOG.info("Failed to load SpaceShipServiceConfig. Reason: {}",
            e.getLocalizedMessage());
        throw new IllegalStateException(e);
      }
    }
    return property;
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

  /**
   * Main property keys.
   */
  private enum PropertyKeys {

    /**
     * Server's property key.
     */
    SERVER(String.class, "server"),
    /**
     * Login's property key.
     */
    LOGIN(String.class, "login"),

    /**
     * Password's property key.
     */
    PASSWORD(String.class, "password");

    private final String key;
    private final Class<?> clazz;

    PropertyKeys(Class<?> clazz, String key) {
      this.key = key;
      this.clazz = clazz;
    }
  }
}
