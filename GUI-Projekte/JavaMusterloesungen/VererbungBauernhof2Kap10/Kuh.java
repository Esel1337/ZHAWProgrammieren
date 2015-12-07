package VererbungBauernhof2Kap10;


public class Kuh implements Tier, Comparable<Kuh> {
  
  private String name;
  
  private int gewicht;
  
  public Kuh(String name, int gewicht) {
    this.name = name;
    this.gewicht = gewicht;
  }
  
  @Override
  public int compareTo(Kuh o) {
//    return this.getName().compareTo(o.getName());
    return this.getGewicht() - o.getGewicht();
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
