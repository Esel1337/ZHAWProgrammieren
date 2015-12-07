package VererbungRollenspiel2Kap10.spielfiguren;

public class Ork extends Spielfigur {

  public Ork(String name) {
    super(name);
  }

  @Override
  protected int getIQ() {
    return 30 + (int) getKampfwert();
  }
}
