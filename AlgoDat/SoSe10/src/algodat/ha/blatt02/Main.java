package algodat.ha.blatt02;

public class Main {

  public static void main (String[] args) {
    //Aufgabe 4, Präsenzübung:
    try {
      TestCases.testStack (new StackList ());
    } catch (IllegalAccessException e) {
      e.printStackTrace ();
    }
    System.out.println ();

    //Hausaufgaben Blatt 2
    try {
      TestCases.testList (new LinkedList ());
    } catch (IllegalAccessException e) {
      e.printStackTrace ();
    }
  }
}
