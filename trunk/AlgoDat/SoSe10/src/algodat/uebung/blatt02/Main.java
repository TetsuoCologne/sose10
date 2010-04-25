package algodat.uebung.blatt02;

public class Main {

  public static boolean checkSyntax (String str) {
    //StackArray stack = new StackArray ();
    StackList stack = new StackList ();
    for (int i = 0; i < str.length (); i++) {
      int klammer = str.charAt (i);
      if (Main.klammerAuf (klammer)) {
        stack.push (klammer);
      } else if (Main.klammerZu (klammer)) {
        try {
          if (!(stack.pop () - klammer <= 2)) {
            return false;
          }
        } catch (IllegalAccessException e) {
          //Stack ist leer, Klammer zu kann also nicht stimmen
          return false;
        }
      }
    }
    if (stack.getCount () != 0) {
      return false;
    } else {
      return true;
    }
  }

  public static boolean klammerAuf (int klammer) {
    if ((klammer == '(') || (klammer == '[') || (klammer == '{')) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean klammerZu (int klammer) {
    if ((klammer == ')') || (klammer == ']') || (klammer == '}')) {
      return true;
    } else {
      return false;
    }
  }

  public static void main (String[] args) {
    try {
      TestCases.testStack (new StackArray ());
      TestCases.testStack (new StackList ());
    } catch (IllegalAccessException e) {
      e.printStackTrace ();
    }

    System.out.println (Main.checkSyntax ("()"));
    System.out.println (Main.checkSyntax ("([{()}])"));
    System.out.println (Main.checkSyntax ("({{{}}})"));
    System.out.println (Main.checkSyntax ("(["));
    System.out.println (Main.checkSyntax ("([)]"));
    System.out.println (Main.checkSyntax ("{{{)))"));

  }
}
