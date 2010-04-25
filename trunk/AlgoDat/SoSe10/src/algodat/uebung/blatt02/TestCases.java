package algodat.uebung.blatt02;

public class TestCases {

  public static void evalTest (String msg,
                               boolean b) {
    System.out.printf ("%s: %b \n", msg, b);
  }

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
    b = ((stack.pop () == 12) && (stack.getCount () == 1));
    TestCases.evalTest ("Stack04", b);

    //Stack05: clear()
    stack.clear ();
    b = (stack.getCount () == 0);
    TestCases.evalTest ("Stack05", b);

  }
}
