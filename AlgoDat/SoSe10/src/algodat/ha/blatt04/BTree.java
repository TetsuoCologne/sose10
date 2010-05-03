package algodat.ha.blatt04;

import java.util.ArrayList;

public class BTree {
	private Node root;
	
	class Node{
		/**ArrayList enthält Werte des Knotens*/
		private ArrayList<Integer> values = new ArrayList<Integer>();
		/**ArrayList enthält Referenzen des Knotens*/
		private ArrayList<Node> references = new ArrayList<Node>();
		
		public int getValue(int i){
			return values.get(i);
		}
		
		public void addValue(int i, int pos){
			if (pos == -1){
				//am ende einfügen
				values.add(i);
			}else {
				values.add(pos, i);
			}
		}
	
		public Node getReference(int i){
			return references.get(i);
		}
		
		public void addReference(Node i, int pos){
			if (pos == -1){
				//am ende einfügen
				references.add(i);
			}else {
				references.add(pos, i);
			}
		}
		
		public boolean hasReferences(){
			return references.isEmpty();
		}
		
		public int valueCount(){
			return values.size();
		}
		
		public int referenceCount(){
			return references.size();
		}
		
	}
	
	public Node search (int value){
		Node node = this.root;
		while (node.hasReferences()){
			for(int i = 0; i < node.valueCount(); i++){
				if (i < node.getValue(i)){
					node = node.getReference(i);
					break;
				} else if(i == node.valueCount() - 1){
					node = node.getReference(++i);
				}
			}
		}
		
		return node;
	}
	
	public void insert (int value){
		
	}
}	
  
