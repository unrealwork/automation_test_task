package com.semrush.tasks.automation.api.services.temperature;

import com.semrush.tasks.automation.model.WaterState;
import org.testng.annotations.DataProvider;

public class TemperatureServiceDataProvider {

  @DataProvider(name = "statusProvider", parallel = true)
  public Object[][] statusProvider() {
    return new Object[][]{
        {"0", 200, "The value \"{0}\" is correct"},
        {"0.000001", 200, "The value \"{0}\" is correct floating value"},
        {"", 400, "The \"{0}\" empty string is incorrect value"},
        {"1.1", 200, "The value \"{0}\" is incorrect floating value"},
        {"100", 200, "The value \"{0}\" is correct for steam"},
        {"-100", 200, "The value \"{0}\" is correct negative integer value"},
        {"abc", 400, "The value \"{0}\" is incorrect string value"}
    };
  }

  @DataProvider(name = "correctStatesProvider", parallel = true)
  public Object[][] correctStatesProvider() {
    return new Object[][]{
        {0, WaterState.Ice, "The temperature {0} is when water becomes ice"},
        {24, WaterState.Ice,
            "The temperature {0} is included in the water interval"},
        {100, WaterState.Steam, "The temperature {0} when water becomes steam"},
        {-100, WaterState.Ice, "The temperature {0} is typical for ice"},
        {120, WaterState.Steam, "The temperature {0} is typical for steam"}
    };
  }
}
