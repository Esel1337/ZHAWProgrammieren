package VererbungAbstrakteKlassenuInterfacesEnteKap10;




public class Stockente extends Ente {
  
  public Stockente() {
    setFlugverhalten(new FliegtMitFluegel());
    setQuakverhalten(new Quaken());
  }

  @Override
  public void anzeigen() {
    System.out.println("Sehe aus wie Stockente");
    
  }
}
