package com.semrush.tasks.automation.model;

/**
 * Describes spaceship's water environment.
 */
public final class WaterEnvironment {

  /**
   * State of water.
   */
  private WaterState state;

  /**
   * Default constructor hidden for safety.
   */
  private WaterEnvironment() {
  }

  /**
   * Main constructor.
   *
   * @param stateValue - a state of water.
   */
  public WaterEnvironment(final WaterState stateValue) {
    this.state = stateValue;
  }

  /**
   * Retrieve state of water in current environment.
   *
   * @return State instance
   */
  public WaterState getState() {
    return state;
  }
}
