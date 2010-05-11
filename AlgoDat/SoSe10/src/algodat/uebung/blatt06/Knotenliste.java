package algodat.uebung.blatt06;

//Vorlage

import java.util.ArrayList;

public class Knotenliste {

	private ArrayList<Integer> liste; // Die Knotenliste

	/* Erzeugt eine Knotenliste aus der Kantenliste a */
	public Knotenliste(Kantenliste a) {
		this.liste = new ArrayList<Integer>();
		this.liste.add(a.get(0));
		this.liste.add(a.get(1));

		int index = 2;
		int node = 1;
		int count = 0;
		while (index < a.size()) {
			while (a.get(index) == node) {
				count++;
				index += 2;
				if (!(index < a.size())) {
					break;
				}
			}
			// wieder zurück setzen
			index -= count * 2;
			this.liste.add(count);
			for (int i = 1; i <= count * 2; i += 2) {
				this.liste.add(a.get(index + i));
			}
			index += count * 2;
			node++;
			count = 0;
		}
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
