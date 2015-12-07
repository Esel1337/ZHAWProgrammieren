package Threads3UhrEinfach.swinguhr;

import java.awt.Font;

import javax.swing.JLabel;

import Threads3UhrEinfach.controller.Zifferblatt;

public class SwingZifferblatt extends JLabel implements Zifferblatt {

  private static final long serialVersionUID = -2199359952440433811L;

  public SwingZifferblatt() {
    setFont(new Font("Uhr", Font.PLAIN, 42));
  }

  @Override
  public void setTime(final String time) {
    setText(time);
  }

}
