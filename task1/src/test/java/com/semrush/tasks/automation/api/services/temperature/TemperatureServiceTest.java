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

@Test(description = "Tests for Temperature Service on SpaceShip")
public class TemperatureServiceTest {

  private TemperatureService service = ShipServiceManager
      .getService(TemperatureService.class);


  @Test(description = "Test correctness of HTTP statuses for different inputs",
      dataProviderClass = TemperatureServiceDataProvider.class,
      dataProvider = "statusProvider")
  public void testStatus(final String value, final int expectedCode,
      final String reason)
      throws IOException {
    //Act
    final Call<Void> call = service.getEnvironmentRaw(value);
    final int actualCode = call.execute().code();
    //Assert
    final String assertMessageTemplate = String.format(
        "Incorrect response http status for following API request {0}.%n "
            + "Value: {1}.%n Reason: {2}.%n Expected : {3}.%n Actual: {4}.%n");
    final String assertMessage = MessageFormat.format(
        assertMessageTemplate, call.request(), value, reason, expectedCode,
        actualCode);

    Assert.assertEquals(actualCode, expectedCode, assertMessage);
  }


  @Test(description = "Test correctness of environment state depends on "
      + "temperature",
      dataProviderClass = TemperatureServiceDataProvider.class,
      dataProvider = "correctStatesProvider")
  public void testCorrectStates(final Integer temperature,
      final WaterState expectedState,
      final String reason)
      throws IOException {
    //Act
    Call<WaterEnvironment> call = service
        .getEnvironment(temperature.toString());
    final WaterState actualState = call
        .execute()
        .body()
        .getState();

    // Assert
    final String assertMessageTemplate = String.format(
        "Incorrect state of water environment for following API "
            + "request {0}."
            + "%nTemperature: {1}.%n Reason: {2}.%n "
            + "Expected : {3}.%n Actual: {4}");
    final String assertMessage = MessageFormat.format(
        assertMessageTemplate,
        call.request(), temperature, reason, expectedState, actualState);

    Assert.assertEquals(actualState, expectedState, assertMessage);
  }
}
