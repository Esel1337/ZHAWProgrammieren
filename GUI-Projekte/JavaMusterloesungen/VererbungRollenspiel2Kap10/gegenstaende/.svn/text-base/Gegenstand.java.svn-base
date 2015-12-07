package lektion10.rollenspiel.gegenstaende;

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
  
  @Override
  public int hashCode() {
    // vereinfachte Version
    return name.hashCode() + gewicht;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    
    if (this == obj) {
      return true;
    }
    
    if (!(obj instanceof Gegenstand)) {
      return false;
    }
    
    Gegenstand other = (Gegenstand) obj;
    
    return this.name.equals(other.getName()) && this.gewicht == other.getGewicht();
  }
}
