package com.semrush.tasks.automation.api.services.temperature;

import static com.semrush.tasks.automation.api.utils.Mocks.TemperatureBounds.ICE_UPPER;
import static com.semrush.tasks.automation.api.utils.Mocks.TemperatureBounds.STEAM_LOWER;

import com.semrush.tasks.automation.api.utils.HttpStatus;
import com.semrush.tasks.automation.api.utils.Mocks.TemperatureBounds;
import com.semrush.tasks.automation.model.WaterState;
import org.testng.annotations.DataProvider;

/**
 * Data providers for temperature test.
 */
public class TemperatureServiceDataProvider {

  /**
   * Shift for temperature.
   */
  private static final int TEMPERATURE_SHIFT = 10;

  /**
   * Provide data for status test.
   *
   * @return array of tes param.
   */
  @DataProvider(name = "statusProvider", parallel = true)
  public Object[][] statusProvider() {
    return new Object[][]{
        {"0", HttpStatus.OK, "Zero is correct"},
        {"0.000001", HttpStatus.OK, "Correct floating value"},
        {"", HttpStatus.BAD_REQUEST, "Empty string is incorrect value"},
        {"1.1", HttpStatus.OK, "Incorrect floating value"},
        {"100", HttpStatus.OK, "Correct value for steam"},
        {"-100", HttpStatus.OK, "Correct negative integer value"},
        {"abc", HttpStatus.BAD_REQUEST, "Incorrect string value"}
    };
  }

  /**
   * Provide valid data.
   *
   * @return array of params.
   */
  @DataProvider(name = "correctStatesProvider", parallel = true)
  public Object[][] correctStatesProvider() {
    return new Object[][]{
        {ICE_UPPER, WaterState.Ice,
            "The temperature when water becomes ice"},
        {ICE_UPPER + TEMPERATURE_SHIFT, WaterState.Water,
            "The temperature is included in the water interval"},
        {STEAM_LOWER, WaterState.Steam,
            "The temperature when water becomes steam"},
        {ICE_UPPER - TEMPERATURE_SHIFT, WaterState.Ice,
            "The temperature is typical for ice"},
        {STEAM_LOWER + TEMPERATURE_SHIFT, WaterState.Steam,
            "The temperature is typical for steam"}
    };
  }

  /**
   * Incorrect data provider.
   *
   * @return array of parmas.
   */
  @DataProvider(name = "incorrectStatesProvider", parallel = true)
  public Object[][] incorrectStatesProvider() {
    return new Object[][]{
        {(long) (TemperatureBounds.ABS_ZERO - TEMPERATURE_SHIFT),
            "The temperature less than absolute zero."},
        {(long) TemperatureBounds.ABS_HOT + TEMPERATURE_SHIFT,
            "The temperature grater than absolute hot"}
    };
  }
}
