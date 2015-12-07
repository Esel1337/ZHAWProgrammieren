package KlassenObjekteAutoMotorKap1u2;
/**
 * Write a description of class Auto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Auto
{
  private String farbe;
  private Motor motor;
  private int nummer;

  public Auto(String farbe) {
    this.farbe = farbe;
  }

  public void setFarbe(String farbe) {
    this.farbe = farbe;
  }

  public String getFarbe() {
    return farbe;
  }

  public void setMotor(Motor motor) {
    this.motor = motor;
  }

  public void setNummer(int nummer) {
    this.nummer = nummer;
  }

  public int getNummer() {
    return nummer;
  }

  public boolean kannFahren() {
    if(motor == null) {
      System.out.println("Kein Motor!");
      return false;
    }

    if(!motor.getZuendkerze()) {
      System.out.println("Motor hat keine Zuendkerze!");
      return false;
    }

    if(nummer < 1) {
      System.out.println("Ungueltige Autonummer");
      return false;
    }

    System.out.println("Ich kann fahren");
    System.out.println("Farbe: " + farbe + " Nummer: " + nummer);
    System.out.println("Hubraum: " + motor.getHubraum());
    return true;

  }

}
