package VererbungAbstrakteKlassenuInterfacesEnteKap10;




public class Teich {
  
  public static void main(String[] args) {
    Ente e1 = new Stockente();
    e1.anzeigen();
    e1.fliegen();
    e1.quaken();
    e1.setQuakverhalten(new Kreischen());
    e1.quaken();
    e1.setFlugverhalten(new FliegtNicht());
    e1.fliegen();
    System.out.println("---------");
    Ente e2 = new Gummiente();
    e2.anzeigen();
    e2.fliegen();
    e2.quaken();
  }

}
