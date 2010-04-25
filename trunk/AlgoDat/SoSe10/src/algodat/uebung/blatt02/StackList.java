package algodat.uebung.blatt02;

public class StackList implements IStack {

  private int  size = 0;

  private Node lastNode;

  @Override
  public void clear () {
    size = 0;
    lastNode = null;
  }

  @Override
  public int getCount () {
    return size;
  }

  @Override
  public int peek () throws IllegalAccessException {
    if (size == 0) {
      throw new IllegalAccessException ("Stack ist leer");
    }
    return lastNode.value;
  }

  @Override
  public int pop () throws IllegalAccessException {
    if (size == 0) {
      throw new IllegalAccessException ("Stack ist leer");
    }
    int result = peek ();
    lastNode = lastNode.prev;
    size--;
    return result;
  }

  @Override
  public void push (int i) {
    Node newNode = new Node ();
    newNode.prev = lastNode;
    newNode.value = i;
    lastNode = newNode;
    size++;
  }

  class Node {

    Node prev;
    int  value;
  }

}
