package com.semrush.tasks.automation.api;

import com.semrush.tasks.automation.config.SpaceShipServiceConfig;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * Manager of different HTTP API wrappers.
 * <pre>
 * {@code
 * TemperatureService service =
 *    ShipServiceManager.getService(TemperatureService.class);
 * }
 * </pre>
 */
public final class ShipServiceManager {

  /**
   * Http client instance.
   */
  private static Retrofit client;

  /**
   * Default config.
   */
  private static final SpaceShipServiceConfig CONFIG =
      SpaceShipServiceConfig.getDefault();

  /**
   * Main constructor hidden for safety.
   */
  private ShipServiceManager() {
  }

  /**
   * Get one of Http Service wrappers with default config.
   *
   * @param shipServiceClass - instance of wrapper's class.
   * @param <T> any class or interface.
   * @return instance of wrapper.
   */
  public static <T> T getService(final Class<T> shipServiceClass) {
    return getClient().create(shipServiceClass);
  }

  /**
   * Get default configured Http Client.
   * @return the instance of client.
   */
  private static synchronized Retrofit getClient() {
    if (client == null) {
      client = new Retrofit.Builder()
          .addConverterFactory(JacksonConverterFactory.create())
          .baseUrl(CONFIG.getServer())
          .build();
    }
    return client;
  }
}
