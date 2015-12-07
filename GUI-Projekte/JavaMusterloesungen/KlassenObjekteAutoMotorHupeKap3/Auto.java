package KlassenObjekteAutoMotorHupeKap3;


/**
 * Write a description of class Auto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Auto
{
    private Hupe hupe;
    private Motor motor;
    
    public Auto(Hupe hupe) {
        this.hupe = hupe;
        this.motor = new Motor();
    }
    
    public void autoStarten() {
        motor.startMotor();
    }
    
    public void autoStoppen() {
        motor.stopMotor();
    }
    
    public void hupen() {
        hupe.hupen();
    }
    
    public boolean isMotorOn() {
        return motor.isMotorOn();
    }
    
    public void setHupe(Hupe hupe) {
        this.hupe = hupe;
    }
}
