package algodat.uebung.blatt09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Textsuche {
	String[][] raetsel = new String[14][];

	public Textsuche() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("raetsel.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int count = 0;
		while (sc.hasNext()) {
			raetsel[count] = sc.nextLine().split(" ");
			count++;
		}
	}

	public String suche(String text) {
		String firstChar = text.charAt(0) + "";
		text = text.toUpperCase();
		for (int i = 0; i < raetsel.length; i++) {
			for (int j = 0; j < raetsel.length; j++) {
				if (firstChar.equals(raetsel[i][j])) {
					if (links(i, j, text)) {
						return ++i + "," + ++j + ", links";
					} else if (rechts(i, j, text)) {
						return ++i + "," + ++j + ", rechts";
					} else if (unten(i, j, text)) {
						return ++i + "," + ++j + ", unten";
					} else if (oben(i, j, text)) {
						return ++i + "," + ++j + ", oben";
					}
				}
			}
		}
		return "nix";
	}

	private boolean oben(int i, int j, String text) {
		if (i - text.length() + 1 < 0) {
			return false;
		}
		for (int x = 0; x < text.length(); x++) {
			if (!(raetsel[i - x][j].equals(text.charAt(x) + ""))) {
				return false;
			}
		}
		return true;
	}

	private boolean unten(int i, int j, String text) {
		if (i + text.length() > 14) {
			return false;
		}
		for (int x = 0; x < text.length(); x++) {
			if (!(raetsel[i + x][j].equals(text.charAt(x) + ""))) {
				return false;
			}
		}
		return true;
	}

	private boolean rechts(int i, int j, String text) {
		if (j + text.length() > 14) {
			return false;
		}
		for (int x = 0; x < text.length(); x++) {
			if (!(raetsel[i][j + x].equals(text.charAt(x) + ""))) {
				return false;
			}
		}
		return true;
	}

	private boolean links(int i, int j, String text) {
		if (j - text.length() + 1 < 0) {
			return false;
		}
		for (int x = 0; x < text.length(); x++) {
			if (!(raetsel[i][j - x].equals(text.charAt(x) + ""))) {
				return false;
			}
		}
		return true;
	}
}
