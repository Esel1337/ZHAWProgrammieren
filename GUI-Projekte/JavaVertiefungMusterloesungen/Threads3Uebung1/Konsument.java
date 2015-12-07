package Threads3Uebung1;


import java.util.Date;
import java.util.List;

public class Konsument implements Runnable {

  private List<Date> list;
  
  public Konsument(List<Date> list) {
    this.list = list;
  }
  
  @Override
  public void run() {
    
    while (true) {
      synchronized (list) {
        try {
          list.wait(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
        if (list.size() > 0) {
          System.out.println("Zeitstempel: " + list.remove(0));
        } else {
          System.out.println("kein Zeitstempel in der Liste. Zeit: " + new Date());
          break;
        }
      }
    }
    
  }

}
