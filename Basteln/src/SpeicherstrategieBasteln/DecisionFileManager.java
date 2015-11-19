package SpeicherstrategieBasteln;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class DecisionFileManager {

	public void save(File file, List<String> decisions) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(decisions);
		}
	}

	public List<String> load(File file) throws IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			List<String> decisions = (List<String>) ois.readObject();
			return decisions;
		}
	}

	public void textSave(File file, List<String> decisions) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

			for (String entry : decisions) {
				writer.write(entry);
				writer.write("\n");
			}

		}

	}


	public List<String> textLoad(File file) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String eintrag = reader.readLine();
			List<String> decisions = new ArrayList();
			while (eintrag != null) {
				
				decisions.add(eintrag);
				eintrag = reader.readLine();
			}

			return decisions;
		}
	}

	public void XMLSave(File file, List<String> decisions) throws IOException {
	//To be implemented
	}

	
	
}
