package StrategypatternKap10;



public class Motorschiff extends Motorfahrzeug {

  private int wasserverdraengung;
  private String name;

  public Motorschiff()
  {
    super("Hoooooorn");
  }


  public void setWasserverdraengung(int cm3) {
    this.wasserverdraengung = cm3;
  }

  public int getWasserverdraengung() {
    return wasserverdraengung;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
