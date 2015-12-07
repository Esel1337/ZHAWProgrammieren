package lektion10.rollenspiel.spielfiguren;

import java.util.ArrayList;
import java.util.List;

import lektion10.rollenspiel.gegenstaende.Gegenstand;
import lektion10.rollenspiel.zauber.Magisch;

public class Zauberer extends Mensch {

	private double magiePunkte;
	
	private List<Magisch> magischeGegenstaende;
	
	public Zauberer(String name, double magiePunkte) {
		super(name);
		this.magiePunkte = magiePunkte;
		this.magischeGegenstaende = new ArrayList<Magisch>();
	}
	
	/**
	 * Benuetzt den gegebenen magischen Gegenstand auf die Ziel-Spielfigur, aber
	 * nur wenn der magischer Gegenstand im Besitze des Zauberers ist.
	 * 
	 * @param magischerGegenstand den magischen Gegenstand
	 * @param ziel die Ziel-Spielfigur
	 */
	public void zaubern(Magisch magischerGegenstand, Spielfigur ziel) {
		if (magischeGegenstaende.contains(magischerGegenstand)) {
			magischerGegenstand.zaubern(ziel);
		}
	}
		
	public void setMagiepunkte(double magiePunkte) {
		this.magiePunkte = magiePunkte;
	}
	
	@Override
	public boolean nehmeGegenstand(Gegenstand gegenstand) {
	  if (super.nehmeGegenstand(gegenstand)) {			
			if (gegenstand instanceof Magisch) {
				Magisch m = (Magisch) gegenstand;
				magischeGegenstaende.add(m);
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected int getIQ() {
		return super.getIQ() + (int) (magiePunkte / 2);
	}

}
