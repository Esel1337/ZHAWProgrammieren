package Threads3Uebung1;



import java.util.Date;
import java.util.List;

public class Produzent implements Runnable {

  private List<Date> list;
  
  public Produzent(List<Date> list) {
    this.list = list;
  }
  
  @Override
  public void run() {
    
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (list) {
        list.add(new Date());
        list.notify();
      }
    }
    
  }

}
