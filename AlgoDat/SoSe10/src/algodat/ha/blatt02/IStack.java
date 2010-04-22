package algodat.ha.blatt02;

public interface IStack {

  void push (int i);

  int pop () throws IllegalAccessException;

  int peek () throws IllegalAccessException;

  int getCount ();

  void clear ();

}
