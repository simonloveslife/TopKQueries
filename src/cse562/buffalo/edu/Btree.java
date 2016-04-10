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
	
	
	public void index(int[] range, Node node){
		int ran = range[1]-range[0];
		if(ran<=order){
			for(int i=0; i<ran; i++){
				ArrayList<Integer> tempkey = new ArrayList<Integer>();
				tempkey.add(i);
				node.setkeys(tempkey);
				node.isleaf = true;
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
			node.getkeys().add(keyup);
			
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
	
	
	public void lookup(int key, Node node){
		if(node.isleaf==true){
			System.out.println(key + " matchs " + node.data);
		}
		
		
		else if(key>=node.getkeys().get(node.keysize()-1)){
			lookup(key, node.getsons().get(node.keysize()-1));
		}
		
		else{
			for(int i=0;i<node.keysize();i++){
				if(key<node.getkeys().get(i))
					lookup(key, node.getsons().get(i-1));
				
			}
			
		}
			
			
		
	}
}
