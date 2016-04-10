package cse562.buffalo.edu;

import java.util.ArrayList;

public class Btree {
	int order;
	Node root;
	
	public Btree(int order){
		this.order = order;
		this.root.setfather(null);
		this.root.setkeys(new ArrayList<Integer>());
		this.root.setsons(new ArrayList<Node>());
	}
	
	
	public void index(int n){
		
		
		
	}
	
	public Node lookup(int key){
		
		
		return null;
	}
}
