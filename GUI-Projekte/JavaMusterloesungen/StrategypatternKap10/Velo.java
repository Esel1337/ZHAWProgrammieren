package StrategypatternKap10;



public class Velo extends Fahrzeug {

  private int anzahlGaenge;

  public Velo(int anzahlGaenge)
  {   
    super("klingeling");
    this.anzahlGaenge = anzahlGaenge;
  }

  public int getAnzahlGaenge() {
    return anzahlGaenge;
  }
}
