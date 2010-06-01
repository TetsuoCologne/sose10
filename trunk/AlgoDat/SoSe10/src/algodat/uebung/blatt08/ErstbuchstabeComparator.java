package algodat.uebung.blatt08;

import java.util.Comparator;

public class ErstbuchstabeComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1.charAt(0) > o2.charAt(0))
			return 1;
		else if (o1.charAt(0) < o2.charAt(0))
			return -1;
		else
			return 0;
	}

}
