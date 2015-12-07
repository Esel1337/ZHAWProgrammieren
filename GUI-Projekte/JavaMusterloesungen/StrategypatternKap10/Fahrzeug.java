package StrategypatternKap10;



public abstract class Fahrzeug {
  private Signalton signalton;

  private String farbe;

  private IFortbewegungsart fortbewegungsart;

  public void setFortbewegungsart(IFortbewegungsart fortbewegungsart) {
    this.fortbewegungsart = fortbewegungsart;
  }

  public void bewegen() {
    fortbewegungsart.fortbewegen();
  }

  public Fahrzeug(String signalton) {
    this.signalton = new Signalton(signalton);
  }

  public void signalGeben() {
    System.out.println(signalton.getSignalton());
  }

  public void setFarbe(String farbe) {
    this.farbe = farbe;
  }

  public String getFarbe() {
    return farbe;
  }
}

