public class BTree {

	private BNode wurzel;
	private BNode searchBlatt;
	private int ordnung;

	public BTree(BNode wurzel, int ord) {
		this.wurzel = wurzel;
		this.searchBlatt = null;
		this.ordnung = ord;
	}

	public void insert(int wert) {
		search(wert);
		if(this.searchBlatt != null) {
			insert(this.searchBlatt, wert);
		} else {
			insert(this.wurzel, wert);
		}
	}

	private void insert(BNode node, int wert) {
		node.add(wert);
		if (node.isFull()) {
			int tmp = node.getWerte()[this.ordnung];
			BNode current = new BNode(node.getParent(), tmp, this.ordnung);
			for (int i = 2 * this.ordnung; i >= this.ordnung; --i) {
				current.add(node.getWerte()[i]);
				node.remove(i);
			}
			if (node == this.wurzel) {
				BNode parent = new BNode(null, tmp, this.ordnung);
				parent.setRef(0, node);
				//node.remove(this.ordnung);
				parent.setRef(1, current);
				this.wurzel = parent;
				if (parent.isFull()) {
					insert(parent, wert);
				}
			}
		}
	}

	public boolean search(int search) {
		return search(search, wurzel);
	}

	private boolean search(int search, BNode iter) {

		boolean ret = false;
		if (iter != null) {
			for (int i = 0; i < iter.getCount(); ++i) {
				if (search == iter.getWerte()[i]) {
					ret = true;
					break;
				}
			}

			this.searchBlatt = iter;
			if (!ret) {
				boolean gefunden = false;
				for (int i = 0; i < iter.getCount(); ++i) {
					if (search > iter.getWerte()[i]) {
						gefunden = true;
						search(search, iter.getRef(i));
					}
				}
				if (!gefunden) {
					search(search, iter.getRef(2 * iter.getOrd() + 1));
				}
			}
		}

		return ret;
	}

	public BNode getWurzel() {
		return this.wurzel;
	}
}
