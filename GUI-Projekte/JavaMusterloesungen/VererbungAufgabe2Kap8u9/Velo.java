package VererbungAufgabe2Kap8u9;

public class Velo extends Fahrzeug
{

    private int anzahlGaenge;

    /**
     * Constructor for objects of class Velo
     */
    public Velo(int anzahlGaenge)
    {   
        super("klingeling");
        this.anzahlGaenge = anzahlGaenge;
    }
    
    public int getAnzahlGaenge() {
        return anzahlGaenge;
    }


}
