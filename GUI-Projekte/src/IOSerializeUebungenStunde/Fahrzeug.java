package IOSerializeUebungenStunde;

import java.io.Serializable;

public class Fahrzeug implements Serializable {

	
	private String fahrzeugnummer;

	public Fahrzeug() {
		System.out.println("Das ist jetzt mit ausführung des parameterslosen Kosntruktor");
	}
		
	
	public Fahrzeug(String fahrzeugNummer)
	{
		this.fahrzeugnummer = fahrzeugNummer;
	}
	
	public void setNummer(String fahrzeugnummer) {
		this.fahrzeugnummer = fahrzeugnummer;
	}


	public String getNummer() {
		return fahrzeugnummer;
	}

	
	
	
	
	
}
