package lektion10.rollenspiel.waffen;

public class HandWaffe extends Waffe {

  private int verteidungswert;

  public HandWaffe(int angriffswert, int verteidigungswert) {
    super(angriffswert);
    this.verteidungswert = verteidigungswert;
  }

  public int getVerteidigunswert() {
    return verteidungswert;
  }
  
  @Override
  public int getKampfwert() {
    return super.getKampfwert() + (verteidungswert/2);
  }
}
