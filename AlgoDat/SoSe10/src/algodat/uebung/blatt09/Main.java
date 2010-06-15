package algodat.uebung.blatt09;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Textsuche suche = new Textsuche();
		Scanner sc = new Scanner(System.in);
		String wort = "";
		while (!(wort.equals("x"))) {
			wort = sc.nextLine();
			System.out.println(suche.suche(wort));
		}
		/*
		System.out.println(suche.suche("Analysis"));
		System.out.println(suche.suche("LineareAlgebra"));
		System.out.println(suche.suche("Java"));
		System.out.println(suche.suche("ITGrundlagen"));
		System.out.println(suche.suche("Algorithmen"));
		System.out.println(suche.suche("Stochastik"));
		System.out.println(suche.suche("Datenbanken"));
		System.out.println(suche.suche("SoftwareEng"));
		*/
	}
}
