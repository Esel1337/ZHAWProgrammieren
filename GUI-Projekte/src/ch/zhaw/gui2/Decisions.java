package ch.zhaw.gui2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Decisions {

	private List<String> decisions;
	private Random random;

	public Decisions() {
		decisions = new ArrayList<String>();
		initDecisions();
	}

	public void initDecisions() {
		decisions.add("Kino");
		decisions.add("Konzert");
		decisions.add("Grossmutter");
		decisions.add("Party");
		decisions.add("Essen gehen");
	}

	public void enterDecisions(String text) {
		if (!decisions.contains(text)) {
			decisions.add(text);
		} else {
			System.out.println("Eintrag schon vorhanden");
		}

	}

	public String getRandomDecision() {
		random = new Random();
		int randomIndex = random.nextInt(decisions.size());
		return decisions.get(randomIndex);
	}

	public String getSize()
	{
		
		return "Du hast " + (decisions.size()) + " Entscheidungen zur Verfügung.";
	}

}
