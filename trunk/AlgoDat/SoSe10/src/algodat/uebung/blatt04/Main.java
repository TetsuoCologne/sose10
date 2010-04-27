package algodat.uebung.blatt04;

public class Main {
	public static void main(String[] args) {
		AssoziativesFeld a = new AssoziativesFeld();
		a.add("TM", "Thomas Meier");
		a.add("Müller", "Matthias Müller");
		a.add("Klinsi", "Winke Klinsmann");
		a.add("Merkel", "Angie Merkel");
		a.add("Stoiber", "Hans-Rapid Stoiber");
		a.add("Schäuble", "Big Brother Schäuble");
		System.out.println(a);
		System.out.println(a.get("Klinsi"));
		System.out.println(a.get("Stoiber"));
		System.out.println(a.get("Stoibär"));
		System.out.println(a.get("Schäuble"));
		System.out.println(a.get("Schläuble"));
	}
	
	
}
