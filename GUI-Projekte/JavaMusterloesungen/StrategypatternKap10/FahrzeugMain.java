package StrategypatternKap10;



public class FahrzeugMain {

  public static void main(String[] args) {
    Auto a = new Auto();
    System.out.println("Aufruf von bewegen");
    a.bewegen();
    System.out.println("Fahre in den See");
    a.setFortbewegungsart(new Schwimmen());
    System.out.println("Aufruf von bewegen");
    a.bewegen();
  }
}
