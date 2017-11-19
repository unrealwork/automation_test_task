package com.semrush.tasks.automation.api.utils;

/**
 * Contains mocks of some models.
 */
public final class Mocks {

  /**
   * Temperature bounds of water states.
   */
  public final class TemperatureBounds {

    /**
     * Absolute hot bound.
     */
    public static final int ABS_HOT = Integer.MAX_VALUE;

    /**
     * Absolute zero.
     */
    public static final int ABS_ZERO = -273;

    /**
     * Water to steam transition.
     */
    public static final int STEAM_LOWER = 100;


    /**
     * Water to steam transition.
     */
    public static final int ICE_UPPER = 0;

    /**
     * Hides constructor.
     */
    private TemperatureBounds() {

    }
  }
}
