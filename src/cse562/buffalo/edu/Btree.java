package cse562.buffalo.edu;

import java.util.ArrayList;

public class Btree {
	int order;
	Node root;
	int[] range = new int[2];
	
	public Btree(int order){
		this.order = order;// M 
		this.root.setfather(null);
		this.root.setkeys(new ArrayList<Integer>());
		this.root.setsons(new ArrayList<Node>());
	}
	
	
	public void index(int n){
		// index's number less than M, the root is viewed like a leaf
		if(n<=order){
			for(int i=0; i<n; i++){
				ArrayList<Integer> tempkey = new ArrayList<Integer>();
				tempkey.add(i);
				root.setkeys(tempkey);
			}
			
		}
		
		else{
			int keyup = n/order;
			int tkey = 0;
			while(tkey+keyup<n){
				root.getkeys().add(keyup);
				
				range[0] = tkey;
				range[1] = tkey+keyup-1;
				if(keyup<=order){
					Node newnode = new Node(true, false);
					newnode.setfather(root);
					root.getsons().add(newnode);
					root.getkeys().add(tkey);
					index(range, newnode);
				}
				else{
					Node newnode = new Node(false, false);
					newnode.setfather(root);
					root.getsons().add(newnode);
					root.getkeys().add(tkey);
					index(range, newnode);
				}
				tkey+=keyup;
				
			}
			root.getkeys().add(keyup);
			
			range[0] = tkey;
			range[1] = n;
			if(keyup<=order){
				Node newnode = new Node(true, false);
				newnode.setfather(root);
				root.getsons().add(newnode);
				root.getkeys().add(tkey);
				index(range, newnode);
			}
			else{
				Node newnode = new Node(false, false);
				newnode.setfather(root);
				root.getsons().add(newnode);
				root.getkeys().add(tkey);
				index(range, newnode);
			}
			
			
		}
			
		
		
	}
	
	public void index(int[] range, Node node){
		int ran = range[1]-range[0];
		
		if(node.isleaf){
			for(int i=0; i<ran; i++){
				ArrayList<Integer> tempkey = new ArrayList<Integer>();
				tempkey.add(i);
				node.setkeys(tempkey);
			}
		}
		
		else{
			int keyup = ran/order;
			int tkey = 0;
			while(tkey+keyup<ran){
				node.getkeys().add(keyup);
				
				range[0] = tkey;
				range[1] = tkey+keyup-1;
				if(keyup<=order){
					Node newnode = new Node(true, false);
					newnode.setfather(node);
					node.getsons().add(newnode);
					node.getkeys().add(tkey);
					index(range, newnode);
				}
				else{
					Node newnode = new Node(false, false);
					newnode.setfather(node);
					node.getsons().add(newnode);
					node.getkeys().add(tkey);
					index(range, newnode);
				}
				tkey+=keyup;
				
			}
			root.getkeys().add(keyup);
			
			range[0] = tkey;
			range[1] = ran;
			if(keyup<=order){
				Node newnode = new Node(true, false);
				newnode.setfather(node);
				node.getsons().add(newnode);
				node.getkeys().add(tkey);
				index(range, newnode);
			}
			else{
				Node newnode = new Node(false, false);
				newnode.setfather(node);
				node.getsons().add(newnode);
				node.getkeys().add(tkey);
				index(range, newnode);
			}
			
			
		}
	}
	
	public Node lookup(int key){
		
		
		return null;
	}
}
