package Threads3UhrEinfach.consoleuhr;
import Threads3UhrEinfach.controller.Uhrwerk;
import Threads3UhrEinfach.controller.Zifferblatt;

public class Uhr {

  private final Uhrwerk uhrwerk;
  private final Zifferblatt zifferblatt;
  
  public Uhr() {
    this.zifferblatt = new ConsoleZifferblatt();
    this.uhrwerk = new Uhrwerk(zifferblatt);
    
    uhrwerk.start();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
    }
    uhrwerk.stop();
  
  }
  
  public static void main(String[] args) {
    new Uhr();
  }
  
}
