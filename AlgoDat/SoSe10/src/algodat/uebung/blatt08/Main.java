package algodat.uebung.blatt08;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		Sortierer sort = new Sortierer();
		try {
			sort.readFile(new File("games-ign.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("*************************");
		sort.sortSimple(Sortierer.ERSTBUCHSTABE);
		System.out.println("Simple-Sort Erstbuchstabe:\n" + sort);
		System.out.println("*************************");
		sort.sortSelection(Sortierer.NAME);
		System.out.println("Selection-Sort Name:\n" + sort);
		System.out.println("*************************");
		sort.sortCollection(Sortierer.LAENGE);
		System.out.println("Collection Länge:\n" + sort);
	}
}
