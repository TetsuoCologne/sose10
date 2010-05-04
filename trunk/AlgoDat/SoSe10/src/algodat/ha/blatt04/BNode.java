package algodat.ha.blatt04;

public class BNode {

	private BNode parentRef;
	private int anzElemente;
	private int[] myWerte;
	private BNode[] myRefs;
	private int ordnung;
	
	public BNode(BNode parent, int wert, int ordnung) {		// ordnung muss der des baumes entsprechen!
		this.ordnung = ordnung;
		myWerte = new int[(2*this.ordnung)+1]; // +1 für Überfüllung
		this.parentRef = parent;
		this.anzElemente = 0;
		myRefs = new BNode[((2*this.ordnung)+1)];
		for(int i = 0; i < 2*this.ordnung+1; ++i)
			myRefs[i] = null;
		add(wert);
	}
	
	public void add(int wert) {
		this.myWerte[this.anzElemente] = wert;
		this.anzElemente++;
		sort();
	}
	
	public void sort() {
		int tmp;
		for(int i = 0; i < anzElemente-1; ++i) {
			for(int j = i; j >= 0; --j) {
				if(myWerte[j+1] < myWerte[j]) {
					tmp = myWerte[j];
					myWerte[j] = myWerte[j+1];
					myWerte[j+1] = tmp;
				}
			}
		}
	}
	
	public BNode getRef(int index) {
		return (0 <= index && 2*this.ordnung+1 > index ? myRefs[index] : null);
	}
	
	public void setRef(int idx, BNode ref) {
		myRefs[idx] = ref;
	}
	
	public void remove(int idx) {
		for(int i = idx; i < this.anzElemente-1; ++i) {
			this.myWerte[i] = this.myWerte[i+1];
		}
		--this.anzElemente;
	}
	
	public int[] getWerte() {
		return this.myWerte;
	}
	
	public boolean isFull() {
		return (anzElemente > 2 * this.ordnung);
	}
	
	public boolean isUnderflow() {
		return (this.anzElemente < this.ordnung);
	}
	
	public BNode getParent() {
		return this.parentRef;
	}
	
	public int getCount() {
		return this.anzElemente;
	}
	
	public int getOrd() {
		return this.ordnung;
	}
	
	public boolean isBlatt() {
		boolean ret = false;
		for(int i = 0; i < 2*this.ordnung + 1; ++i) {
			if(myRefs[i] != null) {
				ret = true;
				break;
			}
		}
		return ret;
	}
}
