package VererbungAufgabe2Kap8u9;

public class Motorfahrzeug extends Fahrzeug
{
    private Motor motor;
    
    public Motorfahrzeug(String ton) {
        super(ton);
        motor = new Motor();
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
