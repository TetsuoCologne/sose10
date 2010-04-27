package algodat.uebung.blatt04;

import java.util.ArrayList;
import java.util.Collections;

public class AssoziativesFeld {

	class Element implements Comparable<String> {
		String schluessel;
		Object data;

		@Override
		public int compareTo(String o) {
			return this.schluessel.compareTo(o);
		}
		
		public String toString() {
			return this.schluessel + " " + this.data;
		}

	}

	public ArrayList<Element> liste = new ArrayList<Element>();

	public Object get(String schluessel) {
		if (this.contains(schluessel))
			return this.liste.get(java.util.Collections.binarySearch(this.liste,
				schluessel));
		else
			return null;
	}

	public boolean contains(String schluessel) {
		return (Collections.binarySearch(this.liste, schluessel) >= 0);
	}

	public boolean add(String schluessel, Object data) {
		if (!(this.contains(schluessel))) {
			Element e = new Element();
			e.data = data;
			e.schluessel = schluessel;
			this.liste.add(Math.abs(Collections.binarySearch(this.liste,
					schluessel)) - 1, e);
			return true;
		}
		return false;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < this.liste.size(); i++){
			result += this.liste.get(i) + "\n";
		}
		return result;
	}
}
