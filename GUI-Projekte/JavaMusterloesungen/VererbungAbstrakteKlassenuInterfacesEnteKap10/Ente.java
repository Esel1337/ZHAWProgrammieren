package VererbungAbstrakteKlassenuInterfacesEnteKap10;


public abstract class Ente {

  private Flugverhalten flugverhalten;
  
  private Quakverhalten quakverhalten;
  
  public abstract void anzeigen();
  
  public void fliegen() {
    flugverhalten.fliegen();
  }
  
  public void quaken() {
    quakverhalten.quaken();
  }
  
  public void setFlugverhalten(Flugverhalten f) {
    this.flugverhalten = f;
  }
  
  public void setQuakverhalten(Quakverhalten q) {
    this.quakverhalten = q;
  }
  
}
