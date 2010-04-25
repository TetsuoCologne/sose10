package algodat.uebung.blatt02;

public interface IStack {

  void clear ();

  int getCount ();

  int peek () throws IllegalAccessException;

  int pop () throws IllegalAccessException;

  void push (int i);

}
