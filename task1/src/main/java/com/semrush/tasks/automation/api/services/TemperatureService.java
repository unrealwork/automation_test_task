package com.semrush.tasks.automation.api.services;

import com.semrush.tasks.automation.model.WaterEnvironment;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Contains main functions of temperature HTTP API.
 */
public interface TemperatureService {

  /**
   * Retrieve spaceship water by temperature.
   *
   * @param value - string value  of temperature.
   * @return WaterEnvironment class instance.
   */
  @GET("/")
  Call<WaterEnvironment> getEnvironment(@Query("temperature") String value);
}
