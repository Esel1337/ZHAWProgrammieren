package VererbungAufgabe2Kap8u9;

public class Auto extends Motorfahrzeug
{

    private String autoNr;
    
    public Auto() {
        super("huup");
    }
    
    public String getAutoNr() {
        return autoNr;
    }
    
    public void setAutoNr(String nr) {
        autoNr = nr;
    }
    
}
