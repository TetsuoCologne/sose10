package algodat.uebung.blatt06;

//Vorlage

import java.util.ArrayList;

public class Kantenliste {

	private ArrayList<Integer> liste; // Die Kantenliste

	/* Erzeugt eine Kantenliste aus der Knotenliste a */
	public Kantenliste(Knotenliste a) {
		this.liste = new ArrayList<Integer>();
		this.liste.add(a.get(0));
		this.liste.add(a.get(1));
		int index = 2;
		int node = 1;
		while (index < a.size()) {
			int count = a.get(index);

			for (int i = 1; i <= count; i++) {
				this.liste.add(node);
				this.liste.add(a.get(index + i));
			}
			index += count + 1;
			node++;
		}

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
		String result = "|" + this.get(0) + "|" + this.get(1) + "|";
		for (int i = 2; i < this.size(); i++) {

			result += this.get(i);
			if (i != this.size() - 1) {
				result += ",";
			}
		}
		return result;
	}
}
