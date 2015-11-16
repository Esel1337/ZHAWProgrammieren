package IOSerializeUebungenStunde;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Los {

	private static final String SPEICHERORT = "C:/Users/Micael/Desktop/Test.ugauga";

	public void serialiereAuto(Auto auto) {
		try (FileOutputStream fos = new FileOutputStream(SPEICHERORT);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(auto);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void deserialisiereAuto() {
		try (FileInputStream fis = new FileInputStream(SPEICHERORT);
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			// das kann eine Expceiton werfen
			// wir wissen wir haben ein Auto gespeichert. Was machen wir also
			// als rückgabe? Ein Auto. Also
			// casten wir ein auto:
			Auto auto = (Auto) ois.readObject();
			System.out.println(auto.getFarbe());
			System.out.println(auto.getNummer());
			System.out.println(auto.getMotor());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Los().serialiereAuto(new Auto("grün", BS75553, new Motor(500)));
		new Los().deserialisiereAuto();
	}
}
