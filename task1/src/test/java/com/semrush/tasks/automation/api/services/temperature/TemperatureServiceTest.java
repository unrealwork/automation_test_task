package com.semrush.tasks.automation.api.services.temperature;

import com.semrush.tasks.automation.api.ShipServiceManager;
import com.semrush.tasks.automation.api.services.TemperatureService;
import com.semrush.tasks.automation.api.utils.HttpStatus;
import com.semrush.tasks.automation.model.WaterEnvironment;
import com.semrush.tasks.automation.model.WaterState;
import java.io.IOException;
import java.text.MessageFormat;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;

/**
 * Temperature tests.
 */
public class TemperatureServiceTest {

  /**
   * Instance of temperature service that implement HTTP API.
   */
  private TemperatureService service = ShipServiceManager
      .getService(TemperatureService.class);

  /**
   * Test for correctness of HTTP statuses for different values.
   *
   * @param value {@link String} value
   * @param expectedCode expected HTTTP status code
   * @param reason reason
   * @throws IOException with connection problem.
   */
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


  /**
   * Test water state for correct values of temp.
   *
   * @param temperature - floating value of temperature.
   * @param expectedState - expected water state.
   * @param reason reason
   * @throws IOException with connection problem.
   */
  @Test(description = "Test correctness of environment state depends on "
      + "temperature",
      dataProviderClass = TemperatureServiceDataProvider.class,
      dataProvider = "correctStatesProvider")
  public void testCorrectStates(final int temperature,
      final WaterState expectedState,
      final String reason)
      throws IOException {
    //Act
    Call<WaterEnvironment> call = service
        .getEnvironment(Integer.toString(temperature));
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

  /**
   * Test that API handle incorrect numeric temparature values.
   *
   * @param temperature - value of temperature.
   * @param reason reason
   * @throws IOException with connection problem.
   */
  @Test(description = "Test validation of incorrect temperature value"
      + "temperature",
      dataProviderClass = TemperatureServiceDataProvider.class,
      dataProvider = "incorrectStatesProvider")
  public void testIncorrectStates(final Long temperature, final String reason)
      throws IOException {

    //Act
    Call<WaterEnvironment> call = service
        .getEnvironment(temperature.toString());

    // Assert
    final String assertMessageTemplate = String.format(
        "The value should be recognized as bad request "
            + "request {0}."
            + "%nTemperature: {1}.%n Reason: {2}.%n "
            + "Expected : {3}.%n Actual: {4}");
    int actualCode = call.execute().code();
    final String assertMessage = MessageFormat.format(
        assertMessageTemplate,
        call.request(), temperature, reason, actualCode,
        HttpStatus.BAD_REQUEST);

    Assert.assertEquals(actualCode, HttpStatus.BAD_REQUEST, assertMessage);
  }
}
