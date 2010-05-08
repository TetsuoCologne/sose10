package algodat.ha.blatt05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class UPN {

  public static void main (String[] args) {
    BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
    HashMap<String, Double> map = new HashMap<String, Double> ();
    String s = "";
    System.out.println ("enter 'q' to quit");
    try {
      while (true) {
        s = in.readLine ();
        if (s.equals ("q")) {
          break;
        }
        System.out.println ("task '" + s + "' => " + analyze (s, map));
      }
    } catch (IOException e) {
      System.out.println (e.getMessage ());
      System.out.println ("q");
    }
  }

  /**
   * Wertet entweder den übergebenen Ausdruck aus und gibt das Ergebnis als
   * String zurück, oder ermittelt im Fall der Form „VarName = UPN-Ausdruck“ den
   * Wert des Ausdrucks und speichert die Variable in mapVars.
   * 
   * @param expr
   *          String der den zu analysierenden Ausdruck enthält
   * @param mapVars
   *          HashMap in der die Variablen gespeichert werden
   * @return String mit dem Ergebnis der jeweils ausgeführten Aktion
   * @throws IOException
   *           bei Verarbeitungsfehlern, z.B. zuwenig Zahlen oder unbekannte
   *           Zeichen
   * @throws IllegalAccessException
   */
  public static String analyze (String expr,
                                HashMap<String, Double> mapVars) throws IOException {
    if (expr.contains ("=")) {
      //Variablen deklaration
      String[] temp = expr.split (" = ");
      String key = temp[0]; //Variablenname
      double value = UPN.eval (temp[1], mapVars);
      mapVars.put (key, value);
      return "variable '" + key + "' defined, value = " + value;
    } else {
      //normale Rechnung
      return "result = " + UPN.eval (expr, mapVars);
    }
  }

  /**
   * Führt die stapelbasierte Auswertung eines Ausdrucks in UPN Form durch. Darf
   * Variablen enthalten die in mapVars enthalten sind.
   * 
   * @param exprUPN
   *          String mit Ausdruck in UPN-Form
   * @param mapVars
   *          HashMap mit den definierten Variablen
   * @return Ergebnis der rechnung als double
   * @throws IOException
   *           bei Verarbeitungsfehlern, z.B. zuwenig Zahlen oder unbekannte
   *           Zeichen
   * @throws IllegalAccessException
   */
  public static double eval (String exprUPN,
                             HashMap<String, Double> mapVars) throws IOException {
    Stack<Double> stack = new Stack<Double> ();
    String[] expr = exprUPN.split (" ");
    for (int i = 0; i < expr.length; i++) {
      String current = expr[i];
      if (UPN.isNumber (current)) {
        stack.push (Double.parseDouble (current));
      } else if (UPN.isOperator (current)) {
        if (stack.size () > 1) {
          double b = stack.pop ();
          double a = stack.pop ();
          stack.push (UPN.calculate (a, b, current));
        } else {
          throw new IOException ("Zu wenig Zahlen übergeben");
        }
      } else {
        //testen ob das ganze eine Variable ist
        if (mapVars.containsKey (current)) {
          stack.push (mapVars.get (current));
        } else {
          throw new IOException ("Unbekannte Eingabe: " + current);
        }
      }
    }
    if (stack.size () != 1) {
      throw new IOException ("Fehler bei der Eingabe");
    }

    return stack.pop ();
  }

  /**
   * Prüft ob der übergebene String eine Zahl ist oder nicht.
   * 
   * @param s
   *          zu überprüfender String
   * @return true = Zahl, false = keine Zahl
   */
  public static boolean isNumber (String s) {
    try {
      Double.parseDouble (s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Prüft ob der übergebene String eine der Operatoren "+", "-", "*", "/" ist.
   * 
   * @param s
   *          zu überprüfender String
   * @return true = Operator, false = kein Operator
   */
  public static boolean isOperator (String s) {
    if (s.equals ("+") || s.equals ("-") || s.equals ("*") || s.equals ("/")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Führt die eigentliche Rechnung anhand der übergebene Werte und des
   * Operators durch
   * 
   * @param a
   *          erste Zahl als double
   * @param b
   *          zweite Zahl als double
   * @param operator
   *          Rechenoperator als String
   * @return Ergebnis der Rechnung als double
   * @throws IOException
   *           falls ein ungültiger Operator übergeben wird
   */
  public static double calculate (double a,
                                  double b,
                                  String operator) throws IOException {
    if (operator.equals ("+")) {
      return a + b;
    } else if (operator.equals ("-")) {
      return a - b;
    } else if (operator.equals ("*")) {
      return a * b;
    } else if (operator.equals ("/")) {
      return a / b;
    } else {
      //zur Sicherheit, 0sollte nie vorkommen, da das ganze ja eigentlich schon vorher überprüft wurde
      throw new IOException ("Operator unbekannt");
    }
  }
}
