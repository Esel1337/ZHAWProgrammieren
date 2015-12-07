package StrategypatternKap10;


public class Auto extends Motorfahrzeug {
  private String autoNr;

  public Auto() {
    super("huup");
    setFortbewegungsart(new Fahren());
  }

  public String getAutoNr() {
    return autoNr;
  }

  public void setAutoNr(String nr) {
    autoNr = nr;
  }
}
