package algodat.ha.blatt04;

public class TestBTree {

	public static void main(String args[]) {

		int ord = 2;
		BNode wurz = new BNode(null, 20, ord);
		BTree baum = new BTree(wurz, ord);
		baum.insert(25);
		baum.insert(15);
		baum.insert(5);
		baum.insert(35);

	}

}
