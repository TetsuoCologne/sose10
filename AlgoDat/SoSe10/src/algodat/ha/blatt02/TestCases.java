package algodat.ha.blatt02;

public class TestCases {

  public static void testStack (IStack stack) throws IllegalAccessException {
    boolean b;

    //Stack01: getCount()
    b = (stack.getCount () == 0);
    TestCases.evalTest ("Stack01", b);

    //Stack02: push(int i)
    stack.push (1);
    stack.push (12);
    b = (stack.getCount () == 2);
    TestCases.evalTest ("Stack02", b);

    //Stack03: peek()
    b = (stack.peek () == 12);
    TestCases.evalTest ("Stack03", b);

    //Stack04: pop()
    b = (stack.pop () == 12 && stack.getCount () == 1);
    TestCases.evalTest ("Stack04", b);

    //Stack05: clear()
    stack.clear ();
    b = (stack.getCount () == 0);
    TestCases.evalTest ("Stack05", b);

  }

  public static void evalTest (String msg,
                               boolean b) {
    System.out.printf ("%s: %b \n", msg, b);
  }

  public static void testList (IList list) throws IllegalAccessException {
    boolean b;

    //List01: getCount()
    b = (list.getCount () == 0);
    TestCases.evalTest ("List01", b);

    //List02: insertAt()
    list.insertAt (0, 0);
    b = (list.getCount () == 1);
    TestCases.evalTest ("List02", b);

    //List03: getAt()
    b = (list.getAt (0) == 0);
    TestCases.evalTest ("List03", b);

    //List04: removeAt()
    list.removeAt (0);
    b = (list.getCount () == 0);
    TestCases.evalTest ("List04", b);

    //List05: insertAt(), Element in der Mitte einfuegen; getAt() in der Mitte auslesen
    list.insertAt (0, 0);
    list.insertAt (1, 2);
    list.insertAt (1, 1);
    b = (list.getAt (0) == 0 && list.getAt (1) == 1 && list.getAt (2) == 2);
    TestCases.evalTest ("List05", b);

    //List06: removeAt(), Elemente in der Mitte löschen
    list.removeAt (1);
    b = (list.getAt (1) == 2 && list.getCount () == 2);
    TestCases.evalTest ("List06", b);

    //List07: insertAt()/getAt(), Elemente am Ende hinzugüfen/auslesen/löschen mit dem Übergabeparameter -1
    list.insertAt (-1, 3);
    boolean a = (list.getAt (-1) == 3);
    list.removeAt (-1);
    b = (a && list.getAt (-1) == 2);
    TestCases.evalTest ("List07", b);

    //List08: search()
    b = (list.search (0) == 0);
    TestCases.evalTest ("List08", b);

    //List09: search() bei mehrfachem vorkommen soll das erste auftreten berücksichtigt werden (der kleinste Index)
    list.insertAt (-1, 0);
    b = (list.search (0) == 0);
    TestCases.evalTest ("List09", b);

    //List10: search(), kein Ergebnis
    b = (list.search (42) == -1);
    TestCases.evalTest ("List10", b);

    //List11: clear()
    list.clear ();
    b = (list.getCount () == 0);
    TestCases.evalTest ("List11", b);

    //List12: inserAt(),getAt() mehrfach
    for (int i = 0; i < 100; i++) {
      list.insertAt (i, i);
    }
    for (int i = 99; i >= 0 && b; i--) {
      b = (list.getAt (i) == i);
    }
    TestCases.evalTest ("List12", b);

    //List13: insertAt(), getAt(), removeAt() in großer Liste
    list.insertAt (50, 1337);
    a = (list.getAt (50) == 1337 && list.getAt (51) == 50);
    list.removeAt (50);
    b = (list.getAt (50) == 50 && a);
    TestCases.evalTest ("List13", b);
    
    //List14: am Anfang einfügen/auslesen/löschen
    list.insertAt(0, 42);
    a = (list.getAt(0) == 42);
    list.removeAt(0);
    b = (a && list.getAt(0) == 0);
    TestCases.evalTest("List14", b);
  }
}