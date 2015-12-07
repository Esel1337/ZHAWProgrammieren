package VererbungRollenspiel2Kap10.spielfiguren;

public class Mensch extends Spielfigur {

  public Mensch(String name) {
    super(name);
  }

  @Override
  protected int getIQ() {
    return 98 + getGegenstaende().size();
  }
}
