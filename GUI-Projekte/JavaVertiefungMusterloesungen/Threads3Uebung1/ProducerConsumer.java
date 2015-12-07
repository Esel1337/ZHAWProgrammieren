package Threads3Uebung1;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProducerConsumer {
  
  public static void main(String[] args) {
    List<Date> zeiten = new ArrayList<Date>();
    
    Produzent prod = new Produzent(zeiten);
    Konsument ver = new Konsument(zeiten);
    
    Thread prod1 = new Thread(prod);
    Thread ver1 = new Thread(ver);
    
    prod1.start();
    ver1.start();
  }

}
