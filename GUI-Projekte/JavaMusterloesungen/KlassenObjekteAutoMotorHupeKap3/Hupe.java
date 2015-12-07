package KlassenObjekteAutoMotorHupeKap3;


/**
 * Write a description of class Hupe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hupe
{
    private String hupton;
    
    public Hupe(String hupton) {
        this.hupton = hupton;
    }
    
    public Hupe() {
        hupton = "Huuup";
    }
    
    public void hupen() {
        System.out.println(hupton);
    }
}
