package VererbungAufgabe1Kap8u9;

public class Fahrzeug
{
    private Signalton signalton;
    
    private String farbe;
    
    public Fahrzeug(String signalton) {
        this.signalton = new Signalton(signalton);
    }
    
    public void signalGeben() {
      System.out.println(signalton.getSignalton());
    }
    
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    
    public String getFarbe() {
        return farbe;
    }
}

