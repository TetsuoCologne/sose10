package algodat.uebung.blatt04;

public class Main {
	public static void main(String[] args) {
		AssoziativesFeld a = new AssoziativesFeld();
		a.add("TM", "Thomas Meier");
		a.add("M�ller", "Matthias M�ller");
		a.add("Klinsi", "Winke Klinsmann");
		a.add("Merkel", "Angie Merkel");
		a.add("Stoiber", "Hans-Rapid Stoiber");
		a.add("Sch�uble", "Big Brother Sch�uble");
		System.out.println(a);
		System.out.println(a.get("Klinsi"));
		System.out.println(a.get("Stoiber"));
		System.out.println(a.get("Stoib�r"));
		System.out.println(a.get("Sch�uble"));
		System.out.println(a.get("Schl�uble"));
	}
	
	
}
