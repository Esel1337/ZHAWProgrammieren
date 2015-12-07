package VererbungBauernhof2Loesung5u6Kap10;



public class Kuh implements Tier {
  
  private String name;
  
  private int gewicht;
  
  public Kuh(String name, int gewicht) {
    this.name = name;
    this.gewicht = gewicht;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the gewicht
   */
  public int getGewicht() {
    return gewicht;
  }

  @Override
  public void gibLaut() {
    System.out.println("Muuuuuuhhhhhhh");
    
  }
  
}
