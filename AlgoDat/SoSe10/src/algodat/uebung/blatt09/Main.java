package algodat.uebung.blatt09;

public class Main {
	public static void main(String[] args) {
		Textsuche suche = new Textsuche();
		System.out.println(suche.suche("Analysis"));
		System.out.println(suche.suche("LineareAlgebra"));
		System.out.println(suche.suche("Java"));
		System.out.println(suche.suche("ITGrundlagen"));
		System.out.println(suche.suche("Algorithmen"));
		System.out.println(suche.suche("Stochastik"));
		System.out.println(suche.suche("Datenbanken"));
		System.out.println(suche.suche("SoftwareEng"));
	}
}
