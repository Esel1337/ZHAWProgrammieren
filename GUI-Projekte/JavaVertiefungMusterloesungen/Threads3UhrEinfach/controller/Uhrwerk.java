package Threads3UhrEinfach.controller;

import java.util.Timer;
import java.util.TimerTask;

import Threads3UhrEinfach.model.Time;


public class Uhrwerk {

  private Timer timer;
  private final Zifferblatt zifferblatt;

  public Uhrwerk(final Zifferblatt zifferblatt) {
    this.zifferblatt = zifferblatt;
  }

  public void start() {
    if (timer == null) {
      timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          final Time time = TimeProvider.getTime();
          zifferblatt.setTime(time.getFormattedTime());
        }
      }, 0, 100);
    }
  }

  public void stop()  {
    if (timer != null) {
      timer.cancel();
      timer = null;
    }
  }

}
