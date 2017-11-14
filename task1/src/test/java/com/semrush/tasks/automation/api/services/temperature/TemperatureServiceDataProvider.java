package com.semrush.tasks.automation.api.services.temperature;

import com.semrush.tasks.automation.model.WaterState;
import org.testng.annotations.DataProvider;

public class TemperatureServiceDataProvider {

  @DataProvider(name = "statusProvider", parallel = true)
  public Object[][] statusProvider() {
    return new Object[][]{
        {"0", 200, "Zero is correct"},
        {"0.000001", 200, "Correct floating value"},
        {"", 400, "Empty string is incorrect value"},
        {"1.1", 200, "Incorrect floating value"},
        {"100", 200, "Correct value for steam"},
        {"-100", 200, "Correct negative integer value"},
        {"abc", 400, "Incorrect string value"}
    };
  }

  @DataProvider(name = "correctStatesProvider", parallel = true)
  public Object[][] correctStatesProvider() {
    return new Object[][]{
        {0, WaterState.Ice, "The temperature when water becomes ice"},
        {24, WaterState.Water,
            "The temperature is included in the water interval"},
        {100, WaterState.Steam, "The temperature when water becomes steam"},
        {-100, WaterState.Ice, "The temperature is typical for ice"},
        {120, WaterState.Steam, "The temperature is typical for steam"}
    };
  }

  @DataProvider(name = "incorrectStatesProvider", parallel = true)
  public Object[][] incorrectStatesProvider() {
    return new Object[][]{
        {-273.5d , "The temperature less than absolute zero."},
        {1.41680571e32d, "The temperature grater than absolute hot"}
    };
  }
}
