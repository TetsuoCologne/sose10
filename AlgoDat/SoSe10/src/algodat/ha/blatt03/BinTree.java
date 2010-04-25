package algodat.ha.blatt03;

public class BinTree {

  private Node root;

  class Node {

    Node parent;
    Node left;
    Node right;
    int  value;
  }

  public void clear () {
    this.root = null;
  }

  public void insert (int value) throws NodeAlreadyExistsException {
    Node newNode = new Node ();
    newNode.value = value;
    if (this.root == null) {
      this.root = newNode;
    } else {
      Node node = this.root;
      while (true) {
        if (value < node.value && node.left != null) {
          node = node.left;
        } else if (value > node.value && node.right != null) {
          node = node.right;
        } else if (value == node.value) {
          throw new NodeAlreadyExistsException ("Knoten " + value + " ist schon vorhanden");
        } else {
          break;
        }
      }
      newNode.parent = node;
      if (value < node.value) {
        node.left = newNode;
      } else {
        node.right = newNode;
      }
    }
  }

  public Node search (int value) throws NodeNotFoundException, TreeEmptyException {
    if (this.root == null) {
      throw new TreeEmptyException ("Baum ist leer");
    }
    Node currentNode = this.root;
    while (true) {
      if (value < currentNode.value) {
        try {
          currentNode = currentNode.left;
        } catch (NullPointerException e) {
          throw new NodeNotFoundException ("Knoten nicht vorhanden");
        }
      } else if (value > currentNode.value) {
        try {
          currentNode = currentNode.right;
        } catch (NullPointerException e) {
          throw new NodeNotFoundException ("Knoten nicht vorhanden");
        }
      } else {
        return currentNode;
      }
    }
  }

  @Override
  public String toString () throws TreeEmptyException {
    if (this.root == null) {
      throw new TreeEmptyException ("Baum ist leer");
    }
    return print (this.root, 0);
  }

  private String print (Node root,
                        int indent) {
    String result = "";
    result += (spaces (indent));
    result += root.value + "\n";

    if (root.left != null) {
      result += print (root.left, indent + 4);
    } else if (root.right != null) {
      result += spaces (indent + 4) + "-\n";
    }

    if (root.right != null) {
      result += print (root.right, indent + 4);
    } else if (root.left != null) {
      result += spaces (indent + 4) + "-\n";
    }
    return result;
  }

  private String spaces (int count) {
    String result = "";
    for (int i = 0; i < count; i++) {
      result += " ";
    }
    return result;
  }

  public void remove (int value) throws TreeEmptyException, NodeNotFoundException {
    if (this.root == null) {
      throw new TreeEmptyException ("Baum ist leer");
    }
    Node n = this.search (value);

    if (n.left == null && n.right == null) {
      //Fall 1, Blatt
      clearNode (n);
    } else if (n.left == null ^ n.right == null) {
      //Fall 2, 1 Kind
      if (n.left == null) {
        copyNode (n.right, n);
      } else {
        copyNode (n.left, n);
      }
    } else if (n.left != null && n.right != null) {
      Node minR = n.right;
      while (minR.left != null) {
        minR = minR.left;
      }
      //n durch minR ersetzen
      copyData (minR, n);
      //rechte Seite von minR nach minR schieben
      if (minR.right != null) {
        copyNode (minR.right, minR);
      } else {
        clearNode (minR);
      }
    }
  }

  private void clearNode (Node n) {
    if (n == this.root) {
      this.root = null;
    } else {
      if (n.parent.left == n) {
        n.parent.left = null;
      } else if (n.parent.right == n) {
        n.parent.right = null;
      }
    }
  }

  private void copyNode (Node n1,
                         Node n2) {
    n2.value = n1.value;
    n2.left = n1.left;
    n2.right = n1.right;
  }

  private void copyData (Node n1,
                         Node n2) {
    n2.value = n1.value;
  }

  public boolean isAVL () {
    Node n = this.root;
    //Linker Teilbaum

    return false;
  }
}
