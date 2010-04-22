package algdat.uebung.blatt03;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 1000000; i++) {
			list.add(i);
		}
		long start, ende;
		int zahl = (int) Math.random() * 1000000;
		// int zahl = 1000;
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			list.contains(zahl);
		}
		ende = System.currentTimeMillis();
		System.out.println((ende - start) / 1000.0 / 1000.0 + "sec");
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			java.util.Collections.binarySearch(list, zahl);
		}
		ende = System.currentTimeMillis();
		System.out.println((ende - start) / 1000.0 + "sec");

		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			Main.myBinarySearch(list, zahl);
		}
		ende = System.currentTimeMillis();
		System.out.println((ende - start) / 1000.0 + "sec");
	}

	public static boolean myBinarySearch(ArrayList<Integer> list, int value) {
		int rechts = list.size();
		int mitte = rechts /= 2;
		int links = 0;
		while (value != mitte) {
			if (value > mitte) {
				links = mitte;
				mitte = ((rechts - mitte) / 2) + mitte;
			} else {
				rechts = mitte;
				mitte = ((mitte - links) / 2) + links;
			}
		}
		return true;
	}
}
