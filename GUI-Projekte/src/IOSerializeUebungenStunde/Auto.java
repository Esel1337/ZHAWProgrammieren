package IOSerializeUebungenStunde;

import java.io.Serializable;

public class Auto extends Fahrzeug implements Serializable{

	private String farbe;
	private Motor motor;
	private int nummer;
	
	public Auto(String farbe, int nummer, Motor motor) {
		setMotor(motor);
		this.farbe = farbe;
		this.setNummer(nummer);
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

}

