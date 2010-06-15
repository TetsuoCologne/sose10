package algodat.uebung.blatt10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reise {
	private ArrayList<String[]> staedte = new ArrayList<String[]>();
	private ArrayList<String> route = new ArrayList<String>();
	private int way = 0;

	public Reise() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("blatt10.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int count = 0;
		while (sc.hasNext()) {
			staedte.add(sc.nextLine().split("\t"));
		}
	}

	public ArrayList<String> route(String start) {
		String nextCity = start;
		route.add(nextCity);
		while (route.size() < 16) {
			int index = getIndex(nextCity);
			nextCity = getNextCity(index);
			route.add(nextCity);
		}
		way += Integer.parseInt(staedte.get(getIndex(nextCity))[(getIndex(route.get(0))+1)]);
		route.add(way+"");
		return route;
	}

	private int getIndex(String stadt) {
		for (int i = 0; i < staedte.size(); i++) {
			if (staedte.get(i)[0].equals(stadt))
				return i;
		}
		return -1;
	}

	private String getNextCity(int index) {
		String[] temp = staedte.get(index);
		int[] temp2 = new int[16];
		for (int i = 0; i < 16; i++) {
			temp2[i] = Integer.parseInt(temp[i + 1]);
			if (temp2[i] == 0)
				temp2[i] = 9999;
		}
		int min = 8000;
		int ind = -1;
		for (int i = 0; i < temp2.length; i++) {
			if (temp2[i] < min) {
				if (!route.contains(getCity(i))) {
					min = temp2[i];
					ind = i;
				}
			}
		}
		way += min;

		return getCity(ind);

	}

	private String getCity(int ind) {
		return staedte.get(ind)[0];
	}
}
