package algodat.uebung.blatt05;

import java.util.ArrayList;

public class SpieleHash {
	private String[] list = new String[110];

	public SpieleHash() {
	}

	private int hashIndex(String spiel){
		int hash = spiel.hashCode();
		int h0 = Math.abs(hash % 100);
		return h0;
	}

	private int hashIncrement(String spiel) {
		int hash = spiel.hashCode();
		hash /= 1000;
		return Math.abs(hash % 100);
	}

	public void add(String spiel) throws ArithmeticException {
		int h0 = hashIndex(spiel);
		int i = hashIncrement(spiel) + 1;
		if (this.list[h0] == null) {
			this.list[h0] = spiel;
		} else {
			int start = h0;
			while (true) {
				h0 += i;
				h0 %= 109;
				if (this.list[h0] == null) {
					this.list[h0] = spiel;
					break;
				} else if (h0 == start) {
					throw new ArithmeticException("Passt nicht mehr");
				}
			}
		}
	}

	public boolean contains(String spiel) {
		int h0 = hashIndex(spiel);
		if (this.list[h0] != null) {
			if (this.list[h0].equals(spiel)) {
				return true;
			} else {
				int start = h0;
				int i = hashIncrement(spiel);
				while (true) {
					h0 += i;
					h0 %= 109;
					if (this.list[h0] == spiel) {
						return true;
					} else if (h0 == start) {
						return false;
					}
				}
			}
		} else {
			return false;
		}
	}
}
