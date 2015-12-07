package VererbungAbstrakteKlassenuInterfacesEnteKap10;



public class Gummiente extends Ente {
  
  public Gummiente() {
    setFlugverhalten(new FliegtNicht());
    setQuakverhalten(new Quitschen());
  }
  
  @Override
  public void anzeigen() {
    System.out.println("Sehe aus wie Gummiente");
  }
}
