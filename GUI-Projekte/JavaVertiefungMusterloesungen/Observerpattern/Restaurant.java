package Observerpattern;

public class Restaurant {

  public static void main(String[] args) {
    
    Erzaehler e = new Erzaehler();
    Zuhoerer1 z1 = new Zuhoerer1();
    Zuhoerer2 z2 = new Zuhoerer2();
    Zuhoererin z = new Zuhoererin();
    
    System.out.println("--- Start ---");
    e.erzaehleWitz();
    
    System.out.println("---");
    e.addObserver(z1);
    
    e.erzaehleWitz();
    System.out.println("...");
    
    e.addObserver(z2);
    e.addObserver(z);
    e.erzaehleWitz();
    System.out.println("--- Ende ---");
    
  }
}
