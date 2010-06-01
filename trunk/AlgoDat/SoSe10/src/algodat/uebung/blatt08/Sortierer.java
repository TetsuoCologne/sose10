package algodat.uebung.blatt08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sortierer {

	private ArrayList<String> list = new ArrayList<String>();
	public static final int NAME = 1;
	public static final int ERSTBUCHSTABE = 2;
	public static final int LAENGE = 3;

	public void readFile(File t) throws FileNotFoundException {
		Scanner sc = new Scanner(t);
		while (sc.hasNext()) {
			String[] temp = sc.nextLine().split("\t");
			list.add(temp[1]);
		}
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i) + "\n";
		}
		return result;
	}

	public void sortSimple(int kriterium) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				switch (kriterium) {
				case NAME:
					if (list.get(i).compareTo(list.get(j)) > 0) {
						Collections.swap(list, i, j);
					}
					break;
				case ERSTBUCHSTABE:
					if (list.get(i).charAt(0) > list.get(j).charAt(0)) {
						Collections.swap(list, i, j);
					}
					break;
				case LAENGE:
					if (list.get(i).length() > list.get(j).length()) {
						Collections.swap(list, i, j);
					}
					break;
				default:
					break;
				}
			}
		}
	}

	public void sortSelection(int kriterium) {
		for (int i = 0; i < list.size(); i++) {
			int small = i;
			for (int j = i + 1; j < list.size(); j++) {
				switch (kriterium) {
				case NAME:
					if (list.get(small).compareTo(list.get(j)) > 0) {
						small = j;
					}
					break;
				case ERSTBUCHSTABE:
					if (list.get(small).charAt(0) > list.get(j).charAt(0)) {
						small = j;
					}
					break;
				case LAENGE:
					if (list.get(small).length() > list.get(j).length()) {
						small = j;
					}
					break;
				default:
					break;
				}
			}
			Collections.swap(list, i, small);
		}
	}

	public void sortCollection(int kriterium) {
		switch (kriterium) {
		case NAME:
			Collections.sort(list, new NameComparator());
			break;
		case ERSTBUCHSTABE:
			Collections.sort(list, new ErstbuchstabeComparator());
			break;
		case LAENGE:
			Collections.sort(list, new LaengeComparator());
			break;
		default:
			break;
		}
	}
}
