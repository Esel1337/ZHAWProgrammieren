package VererbungRollenspielKap8u9.gegenstaende;

public class Gegenstand {

  private String name;

  private int gewicht;

  public Gegenstand(String name, int gewicht) {
    super();
    this.name = name;
    this.gewicht = gewicht;
  }

  public int getGewicht() {
    return gewicht;
  }
  
  public String getName() {
    return name;
  }
}
