package KlassenObjekteAutoMotorHupeKap3;


/**
 * Write a description of class Motor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Motor
{
    private boolean motorOn = false;
    
    public void startMotor() {
        motorOn = true;
    }
    
    public void stopMotor() {
        motorOn = false;
    }
    
    public boolean isMotorOn() {
        return motorOn;
    }
}
