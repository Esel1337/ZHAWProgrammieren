package Threads3UhrEinfach.controller;

import java.time.LocalDateTime;

import Threads3UhrEinfach.model.Time;

/**
 * This class provides the actual time.
 * 
 * @author kaspar
 */
public class TimeProvider {

  /**
   * gets the actual time
   * 
   * @return the actual time
   */
  public static Time getTime() {

    final LocalDateTime now = LocalDateTime.now();
    final int hour = now.getHour();
    final int minute = now.getMinute();
    final int second = now.getSecond();

    return new Time(hour, minute, second);
  }
}
