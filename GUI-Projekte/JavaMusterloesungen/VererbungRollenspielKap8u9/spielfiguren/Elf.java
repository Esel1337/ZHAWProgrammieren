package VererbungRollenspielKap8u9.spielfiguren;
public class Elf extends Spielfigur {

  private int zauberwert;

  public Elf(String name, int zauberwert) {
    super(name);
    this.zauberwert = zauberwert;
  }

  @Override
  public double getKampfwert() {
    return super.getKampfwert() + (zauberwert / 2);
  }
}
