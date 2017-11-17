package com.semrush.tasks.automated.ui.config;


import static com.semrush.tasks.automated.ui.utils.CommonUtils.toJson;

import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class represents Client configuration that describes main options of the
 * test projects. <p> The options can be specified in client.properties file
 * that stores in source resources(2nd priority) or pass as maven param(1st
 * priority). </p>
 */
public final class ClientConfig {

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
   * Maximal login timeout.
   */
  private Long actionTimeout;

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
      instance.actionTimeout =
          Long.parseLong(getProperty(PropertyKeys.ACTION_TIMEOUT))
              * TimeUnit.SECONDS.toMillis(1L);
      LOG.info("SpaceShipServiceConfig was successfully loaded: {}", instance);
    }
    return instance;
  }

  /**
   * Get loginForm of test user.
   *
   * @return String value.
   */
  public String getLogin() {
    return login;
  }

  /**
   * Get password of test user.
   *
   * @return String value.
   */
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

  /**
   * Retrieve servers'url.
   *
   * @return String value.
   */
  public Long getActionTimeout() {
    return actionTimeout;
  }

  /**
   * Retrieve property value by property key.
   *
   * @param propertyKey property key.
   * @return value as {@link String}
   */
  private static String getProperty(final PropertyKeys propertyKey) {
    final String property = System.getProperty(propertyKey.key);
    if (property == null) {
      try {
        PropertiesConfiguration clientProperties = configs
            .properties(CLIENT_PROPERTIES);
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
    return toJson(this);
  }

  /**
   * Main property keys.
   */
  private enum PropertyKeys {

    /**
     * Server's property key.
     */
    SERVER("semrush.url"),
    /**
     * Login's property key.
     */
    LOGIN("semrush.user.login"),

    /**
     * Password's property key.
     */
    PASSWORD("semrush.user.password"),

    /**
     * Password's property key.
     */
    ACTION_TIMEOUT("semrush.action.timeout.sec");

    /**
     * Field that stores property key.
     */
    private final String key;

    /**
     * Enum constructor.
     *
     * @param propertyKey key word in properties file.
     */
    PropertyKeys(final String propertyKey) {
      this.key = propertyKey;
    }
  }
}
