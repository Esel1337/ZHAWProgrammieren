package Threads3UhrEinfach.consoleuhr;

import Threads3UhrEinfach.controller.Zifferblatt;

public class ConsoleZifferblatt implements Zifferblatt {

  @Override
  public void setTime(final String time) {
     System.out.println(time);
  }

}
