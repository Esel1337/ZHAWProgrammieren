package KlassenObjekteAutoMotorKap1u2;

/**
 * Write a description of class Motor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Motor
{
    private int hubraum;
    
    private boolean zuendkerze;
    
    public Motor(int hubraum) {
        this.hubraum = hubraum;
    }
    
    public int getHubraum() {
        return hubraum;
    }
    
    public void setZuendkerze(boolean zuendkerze) {
        this.zuendkerze = zuendkerze;
    }
    
    public boolean getZuendkerze() {
        return zuendkerze;
    }
    
}
