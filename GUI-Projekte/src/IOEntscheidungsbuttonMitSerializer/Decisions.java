package IOEntscheidungsbuttonMitSerializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Decisions implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> decisions;
	private Random random;

	
	public Decisions() {
		decisions = new ArrayList<String>();
		initDecisions();
	}

	public List<String> getDecisions() {
		return decisions;
	}

	//Liste füllen mit Standartwerte
	public void initDecisions() {
		decisions.add("Kino");
		decisions.add("Konzert");
		decisions.add("Grossmutter");
		decisions.add("Party");
		decisions.add("Essen gehen");
	}

	//Einträge hinzufügen
	public void enterDecisions(String text) {
		if (!decisions.contains(text)) {
			decisions.add(text);
			System.out.println("Eintrag hinzugefügt");
		} else {
			System.out.println("Eintrag schon vorhanden");
		}

	}

	//Zufallsentscheidung herausgeben
	public String getRandomDecision() {
		if (decisions.isEmpty()) {

			return "Die Liste ist leer.";

		} else {
			random = new Random();
			int randomIndex = random.nextInt(decisions.size());
			return decisions.get(randomIndex);
		}
	}

	//Liste leeren
	public void listeLoeschen() {
		decisions.removeAll(decisions);
	}

	//Liste ersetzen mit der Liste die extern geladen wurde
	public void listeErsetzen(Decisions liste) {
		this.decisions = liste.getDecisions();
	}

	//Anzahl der Einträge in der Liste
	public String getSize() {
		return "Du hast " + (decisions.size()) + " Entscheidungen zur Verfügung.";
	}

}
