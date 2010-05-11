//Vorlage

public class Main {
	
	public static void main(String[] args) {
	
		int[] knotens = {6, 10, 2, 5, 4, 2, 3, 6, 2, 4, 5, 2, 5, 6, 1, 6, 1, 4};
		System.out.println("Wir überführen eine Knotenliste in eine Kantenliste");
		Knotenliste k1 = new Knotenliste(knotens);
		System.out.println(k1);
		Kantenliste k2 = new Kantenliste(k1);
		System.out.println(k2);
		
		int[] kantens = {6, 10, 1, 5, 1, 4, 2, 3, 2, 6, 3, 4, 3, 5, 4, 5, 4, 6, 5, 6, 6, 4 };
		System.out.println("Wir überführen eine Kantenliste in eine Knotenliste");
		Kantenliste k3 = new Kantenliste(kantens);
		System.out.println(k3);
		Knotenliste k4 = new Knotenliste(k3);
		System.out.println(k4);
	
	}
}
