package algodat.ha.blatt03;

public class Main {

  public static void main (String[] args) {
    BinTree tree = new BinTree ();
    tree.insert (40);
    tree.insert (20);
    tree.insert (50);
    tree.insert (10);
    tree.insert (30);
    tree.insert (60);

    System.out.println (tree);
  }
}
