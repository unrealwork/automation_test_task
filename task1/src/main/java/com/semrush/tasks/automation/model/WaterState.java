package com.semrush.tasks.automation.model;


/**
 * That enum represents states of water.
 */
public enum WaterState {
  /**
   * The gas state of water.
   * Achieves where temperature becomes greater than 100 degree Celsius
   * or 212 Fahrenheit inclusive.
   */
  Steam,

  /**
   * /** The liquid state of water.
   * Upper bound - 100 degree Celsius or 212 Fahrenheit exclusive.
   * Lower bound - 0 degree Celsius or 32 Fahrenheit exclusive
   */
  Water,

  /**
   * The solid state of water.
   * Achieves where temperature becomes less than 0 degree Celsius
   * or 32 Fahrenheit inclusive.
   */
  Ice
}
