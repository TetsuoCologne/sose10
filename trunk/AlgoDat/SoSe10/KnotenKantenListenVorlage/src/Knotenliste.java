//Vorlage

import java.util.ArrayList;

public class Knotenliste {
	
	private ArrayList<Integer> liste; // Die Knotenliste

	/* Erzeugt eine Knotenliste aus der Kantenliste a */
	public Knotenliste(Kantenliste a) {
		
		//TODO
	
	}

	/* Uebernimmt einfach den Inhalt von Feld a als Knotenliste */
	public Knotenliste(int[] a) {
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
