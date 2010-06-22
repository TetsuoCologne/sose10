package algodat.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DeletePackage {
	
	public void delete(String folder){
		File f = new File(folder);
		File[] files = f.listFiles();
		for (int i = 0; i < files.length; i++) {
			work (files [i]);
		}
	}
	
	public void work(File f){
		Scanner sc = null;
		PrintWriter pw = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		while (sc.hasNextLine()){
			String temp = sc.nextLine();
			if (!(temp.startsWith("package"))){
				list.add(temp);
			}
		}
		sc.close();
		try{
			pw = new PrintWriter(f);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			pw.println(list.get(i));
		}
		pw.close();
		
	}
	
}
