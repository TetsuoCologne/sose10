//Vorlage

import java.util.ArrayList;

public class Kantenliste {
	
	private ArrayList<Integer> liste; // Die Kantenliste

	/* Erzeugt eine Kantenliste aus der Knotenliste a */
	public Kantenliste(Knotenliste a) {
		
		//TODO
	}

	/* Uebernimmt einfach den Inhalt von Feld a als Kantenliste */
	public Kantenliste(int[] a) {
		liste = new ArrayList<Integer>();
		for (int element : a) {
			liste.add(element);
		}
	}

	/* Gibt das Element i der Liste zurueck */
	public int get(int i) {
		return liste.get(i);
	}

	public int size() {
		return this.liste.size();
	}
	
	/* Formatierung */
	public String toString() {
	
		//TODO
		
	}
}
