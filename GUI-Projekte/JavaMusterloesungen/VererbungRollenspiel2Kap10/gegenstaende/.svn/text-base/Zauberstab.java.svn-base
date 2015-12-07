package lektion10.rollenspiel.gegenstaende;

import lektion10.rollenspiel.spielfiguren.Spielfigur;
import lektion10.rollenspiel.zauber.Magisch;

public class Zauberstab extends Gegenstand implements Magisch {

	private int zauberkraft;
	
	public Zauberstab(String name, int gewicht) {
		super(name, gewicht);
	}

	@Override
	public void zaubern(Spielfigur ziel) {
		double aufschlag = ziel.getLebenspunkte() / 100 * zauberkraft;
		ziel.setLebenspunkte(ziel.getLebenspunkte() + aufschlag);
	}

	@Override
	public double getZauberkraft() {
		return zauberkraft;
	}
	

}
