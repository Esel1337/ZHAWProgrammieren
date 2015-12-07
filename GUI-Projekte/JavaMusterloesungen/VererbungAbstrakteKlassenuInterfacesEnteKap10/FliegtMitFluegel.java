package VererbungAbstrakteKlassenuInterfacesEnteKap10;




public class FliegtMitFluegel implements Flugverhalten{

  @Override
  public void fliegen() {
    System.out.println("Ich fliege mit Fluegeln");
  }
}
