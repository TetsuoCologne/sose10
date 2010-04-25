package algodat.uebung.blatt02;

import java.util.ArrayList;

public class StackArray implements IStack {

  private ArrayList<Integer> stack = new ArrayList<Integer> ();

  @Override
  public void clear () {
    stack.clear ();
  }

  @Override
  public int getCount () {
    return stack.size ();
  }

  @Override
  public int peek () throws IllegalAccessException {
    if (getCount () == 0) {
      throw new IllegalAccessException ("Stack ist leer");
    }
    return stack.get (getCount () - 1);
  }

  @Override
  public int pop () throws IllegalAccessException {
    if (getCount () == 0) {
      throw new IllegalAccessException ("Stack ist leer");
    }
    int result = peek ();
    stack.remove (getCount () - 1);
    return result;
  }

  @Override
  public void push (int i) {
    stack.add (i);

  }

}
