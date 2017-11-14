package com.semrush.tasks.automation.api.services.temperature;

import com.semrush.tasks.automation.api.ShipServiceManager;
import com.semrush.tasks.automation.api.services.TemperatureService;
import com.semrush.tasks.automation.model.WaterEnvironment;
import com.semrush.tasks.automation.model.WaterState;
import java.io.IOException;
import java.text.MessageFormat;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

public class TemperatureServiceTest {

  private TemperatureService service = ShipServiceManager
      .getService(TemperatureService.class);


  @Test(description = "Test correctness of HTTP statuses for different inputs",
      dataProviderClass = TemperatureServiceDataProvider.class,
      dataProvider = "statusProvider")
  public void testStatus(String value, int expectedCode, String reasonTemplate)
      throws IOException {
    //Act
    Call<WaterEnvironment> call = service.getEnvironment(value);
    Response<WaterEnvironment> response = call.execute();
    final int actual = response.code();
    //Assert
    final String assertMessageTemplate = String.format(
        "Incorrect response http status for following API request {0}.%n "
            + "Reason: {1}%n Expected : {2}.%n Actual: {3}");
    final String assertMessage = MessageFormat.format(
        assertMessageTemplate, call.request(), expectedCode, actual);

    Assert.assertEquals(actual, expectedCode, assertMessage);
  }


  @Test(description = "Test correctness of environment state depends on "
      + "temperature",
      dataProviderClass = TemperatureServiceDataProvider.class,
      dataProvider = "correctStatesProvider")
  public void testCorrectStates(Integer temperature, WaterState expectedState,
      String reasonTemplate)
      throws IOException {
    //Act
    final Call<WaterEnvironment> call = service
        .getEnvironment(temperature.toString());
    final Response<WaterEnvironment> response = call.execute();
    final WaterState actualState = response.body().getState();
    // Assert
    final String failReason = MessageFormat.format(reasonTemplate, temperature);
    final String assertMessageTemplate = String.format(
        "Incorrect state of water environment for following API "
            + "request {0}."
            + "%n Reason: {1}%n Expected : {2}.%n Actual: {3}");
    final String assertMessage = MessageFormat.format(
        assertMessageTemplate,
        call.request(), failReason, expectedState, actualState);

    Assert.assertEquals(actualState, expectedState, assertMessage);
  }
}
