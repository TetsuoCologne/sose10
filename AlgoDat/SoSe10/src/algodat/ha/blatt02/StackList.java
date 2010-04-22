package algodat.ha.blatt02;

public class StackList implements IStack {

  class Node {

    Node prev;
    int  value;
  }

  private int  size = 0;
  private Node lastNode;

  @Override
  public void clear () {
    this.size = 0;
    this.lastNode = null;
  }

  @Override
  public int getCount () {
    return this.size;
  }

  @Override
  public int peek () throws IllegalAccessException {
    if (this.size == 0) {
      throw new IllegalAccessException ("Stack ist leer");
    }
    return this.lastNode.value;
  }

  @Override
  public int pop () throws IllegalAccessException {
    if (this.size == 0) {
      throw new IllegalAccessException ("Stack ist leer");
    }
    int result = this.peek ();
    this.lastNode = this.lastNode.prev;
    this.size--;
    return result;
  }

  @Override
  public void push (int i) {
    Node newNode = new Node ();
    newNode.prev = this.lastNode;
    newNode.value = i;
    this.lastNode = newNode;
    this.size++;
  }

}
