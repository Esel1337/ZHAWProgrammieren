package VererbungAufgabe1Kap8u9;

public class Auto extends Fahrzeug
{

    private String autoNr;
    private Motor motor;
    
    public Auto() {
        super("huup");
        motor = new Motor();
    }
    
    public String getAutoNr() {
        return autoNr;
    }
    
    public void setAutoNr(String nr) {
        autoNr = nr;
    }
    
    public void motorStarten() {
        motor.startMotor();
    }
    
    public void motorStoppen() {
        motor.stopMotor();
    }
    
    
    public boolean isMotorOn() {
        return motor.isMotorOn();
    }
    
}
