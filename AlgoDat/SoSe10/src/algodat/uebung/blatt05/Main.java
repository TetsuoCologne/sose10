package algodat.uebung.blatt05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = null;
		SpieleHash spiele = new SpieleHash();
		try{
			sc = new Scanner(new File("games-ign.txt"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		while (sc.hasNext()){
			String[] temp = sc.nextLine().split("\t");
			try{
				spiele.add(temp[1].trim());
			} catch (ArithmeticException e){
				e.printStackTrace();
			}
		}
		
aa		System.out.println(spiele.contains("Halo: Reach"));
		System.out.println(spiele.contains("Super Mario Galaxy 2"));
		System.out.println(spiele.contains("WOW"));
	}
}
