package algodat.uebung.blatt03;

public class IntQueue implements IQueue {

  private int     head;
  private int     tail;
  private int[]   data;
  private boolean isFull = false;

  public IntQueue (int length) {
    this.data = new int[length];
  }

  @Override
  public void clear () {
    this.head = 0;
    this.tail = 0;
  }

  @Override
  public int getCount () {
    return Math.abs (this.tail - this.head);
  }

  @Override
  public boolean offer (int value) {
    if (this.isFull) {
      return false;
    }
    this.data[tail] = value;
    tail++;
    if (this.head == this.tail) {
      this.isFull = true;
    }
    return true;
  }

  @Override
  public int peek () {
    if (isEmpty ()) {
      return Integer.MAX_VALUE;
    }
    return this.data[head];
  }

  @Override
  public int poll () {
    if (isEmpty ()) {
      return Integer.MAX_VALUE;
    } else {
      if (this.isFull) {
        this.isFull = false;
      }
      return this.data[head++];
    }
  }

  private boolean isEmpty () {
    return this.tail == this.head;
  }
}
