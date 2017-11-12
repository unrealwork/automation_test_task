package com.semrush.tasks.automation.api.services;

import com.semrush.tasks.automation.api.ShipServiceManager;
import com.semrush.tasks.automation.model.WaterEnvironment;
import com.semrush.tasks.automation.model.WaterState;
import java.io.IOException;
import java.text.MessageFormat;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

public class TemperatureServiceTest {

  private TemperatureService service = ShipServiceManager.getService(TemperatureService.class);


  @Test(description = "Test correctness of HTTP statuses for different inputs",
      dataProvider = "statusProvider")
  public void testStatus(String value, int expectedCode) throws IOException {
    Call<WaterEnvironment> call = service.getEnvironment(value);
    Response<WaterEnvironment> response = call.execute();
    final int actual = response.code();
    final String assertMessage = MessageFormat.format(
        "Incorrect response http status for following API request {0}.\n Expected : {1}."
            + " \n Actual: {2}", call.request(), expectedCode, actual);
    Assert.assertEquals(actual, expectedCode, assertMessage);
  }


  @Test(description = "Test correctness of environment state depends on temperature",
      dataProvider = "statesProvider")
  public void testStates(Integer temperature, WaterState expectedState) throws IOException {
    Call<WaterEnvironment> call = service.getEnvironment(temperature.toString());
    Response<WaterEnvironment> response = call.execute();
    final WaterState actualState = response.body().getState();
    final String assertMessage = MessageFormat.format(
        "Incorrect response http status for following API request {0}.\n Expected : {1}."
            + " \n Actual: {2}", call.request(), expectedState, actualState);
    Assert.assertEquals(actualState, expectedState, assertMessage);

  }

  @DataProvider(name = "statusProvider", parallel = true)
  private Object[][] statusProvider() {
    return new Object[][]{
        {"0", 200},
        {"0.000001", 200},
        {"", 200},
        {"1.1", 200},
        {"100", 200},
        {"-100", 200},
        {"abc", 400}
    };
  }

  @DataProvider(name = "statesProvider", parallel = true)
  private Object[][] statesProvider() {
    return new Object[][]{
        {0, WaterState.Ice},
        {24, WaterState.Water},
        {100, WaterState.Steam},
        {Integer.MAX_VALUE, WaterState.Steam},
        {Integer.MAX_VALUE, WaterState.Steam},
        {-100, WaterState.Ice},
    };
  }
}
