package algodat.ha.blatt02;

public class LinkedList implements IList {

	class Node {

		int value;
		Node next;
	}

	private int size = 0;
	private Node head;

	@Override
	public void clear() {
		this.size = 0;
		this.head = null;
	}

	@Override
	public int getAt(int i) throws IllegalAccessException {
		if (i > this.getCount() - 1 || i < -1) {
			throw new IllegalAccessException("ungültiger Index eingegeben");
		} else if (i == -1) {
			i = this.getCount() - 1;
		}
		Node temp = this.head;
		int x = 0;
		while (x < i) {
			temp = temp.next;
			x++;
		}
		return temp.value;
	}

	@Override
	public int getCount() {
		return this.size;
	}

	@Override
	public void insertAt(int i, int value) throws IllegalAccessException {
		if (i > this.getCount() || i < -1) {
			throw new IllegalAccessException("ungültiger Index eingegeben");
		} else if (i == -1) {
			i = this.getCount();
		}

		Node newNode = new Node();
		newNode.value = value;

		if (this.getCount() == 0) {
			// es ist noch kein Node vorhanden
			this.head = newNode;
		} else if (i == 0) {
			// an erster Stelle einfuegen
			newNode.next = this.head;
			this.head = newNode;
		} else {
			Node pred = this.head;
			Node succ;
			int x = 0;
			while (x < i - 1) {
				// liefert Node der an Position i-1 steht
				pred = pred.next;
				x++;
			}
			try {
				// Node der z.Z. noch an Position i steht
				succ = pred.next;
				newNode.next = succ;
			} catch (NullPointerException e) {
				newNode.next = null;
			}
			pred.next = newNode;
		}
		size++;
	}

	@Override
	public void removeAt(int i) throws IllegalAccessException {
		if (i > this.getCount() - 1 || i < -1) {
			throw new IllegalAccessException("ungültiger Index eingegeben");
		} else if (i == -1) {
			i = this.getCount();
		}
		if (this.getCount() == 1) {
			this.clear();
			return;
		}
		if (i == 0) {
			//an erster Stelle loeschen
			this.head = this.head.next;
		} else {
			// Node der gelöscht werden soll
			Node delete = null;
			Node succ = null;
			Node pred = this.head;
			int x = 0;
			while (x < i - 1) {
				// gibt den Vorgänger das zu löschenden Knotens zurück
				pred = pred.next;
				x++;
			}
			delete = pred.next;
			try {
				succ = delete.next;
				pred.next = succ;
				// falls das letzte Element geloescht wird
			} catch (NullPointerException e) {
				pred.next = null;
			}
			this.size--;
		}
	}

	@Override
	public int search(int value) {
		int counter = 0;
		for (Node node = head; node.next != null; node = node.next) {
			if (node.value == value) {
				return counter;
			}
			counter++;
		}
		return -1;
	}

}