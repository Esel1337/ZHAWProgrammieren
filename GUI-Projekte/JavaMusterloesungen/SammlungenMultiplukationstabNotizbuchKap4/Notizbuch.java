package SammlungenMultiplukationstabNotizbuchKap4;
import java.util.ArrayList;


public class Notizbuch {

	private ArrayList<String> notizen; Notizbuch() {
		notizen = new ArrayList<String>();
	}
	
	public void add(String notiz) {
		notizen.add(notiz);
	}
	
	public String getFristMatch(String suchbegriff) {
		for (String notiz : notizen) {
			if (notiz.contains(suchbegriff)) {
				return notiz;
			}
		}
		return null;
	}
	
	public ArrayList<String> getAllMatches(String suchbegriff) {
		ArrayList<String> matches = new ArrayList<String>();
		
		for (String notiz : notizen) {
			if (notiz.contains(suchbegriff)) {
				matches.add(notiz);
			}
		}
		return matches;
	}
}
