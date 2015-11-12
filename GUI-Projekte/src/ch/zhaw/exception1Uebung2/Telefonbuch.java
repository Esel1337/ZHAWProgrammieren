package ch.zhaw.exception1Uebung2;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Telefonbuch {

	private Map<String, String> telBuch;


	public Telefonbuch() {

		telBuch = new TreeMap<>();

	}

	
	public void addEntry(String name, String nummer)
	{
		telBuch.put(name, nummer)
		
	}
	
	
	public void printTelBuch()
	{
	
		 for (Map.Entry<K, V> entry : telBuch.entrySet())
		 {
			    K value = entry.getValue();
		        V key = entry.getKey();
		   }
		
		
		
	}
	
}
