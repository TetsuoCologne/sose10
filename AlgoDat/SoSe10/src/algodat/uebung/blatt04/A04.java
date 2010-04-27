package algodat.uebung.blatt04;

import java.util.ArrayList;
import java.util.Random;

public class A04 {

	public static int XXX(ArrayList<Integer> A, int x) {
		int pos = A.size() / 2;
		while (true) {
			if (A.get(pos) == x)
				return pos;
			if (A.get(pos) < x)
				pos = pos + pos / 2;
			if (A.get(pos) > x)
				pos = pos - pos / 2;
		}
	}

	public static int YYY(ArrayList<Integer> A, int a, int b) {
		int i = a;
		int j = b - 1;
		int p = A.get(b);
		do {
			while (A.get(i) <= p && i < b)
				++i;
			while (A.get(j) >= p && j > a)
				--j;
			if (i < j) {
				int n = A.get(i);
				A.set(i, A.get(j));
				A.set(j, n);
			}
		} while (i < j);
		if (A.get(i) > p) {
			int n = A.get(i);
			A.set(i, A.get(b));
			A.set(b, n);
		}
		return i;
	}

	public static void ZZZ(ArrayList<Integer> A, int a, int b) {
		if (a < b) {
			int p = YYY(A, a, b);
			ZZZ(A, a, p - 1);
			ZZZ(A, p + 1, b);
		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < 100000; ++i)
			A.add(i);
		System.out.println("XXX: "+XXX(A,A.size()-1));

		System.out.println("ZZZ 1: " + A.toString());
		ZZZ(A, 0, A.size() - 1);
		System.out.println("ZZZ 2: " + A.toString());
	}

}
