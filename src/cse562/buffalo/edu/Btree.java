package cse562.buffalo.edu;

import java.util.ArrayList;

public class Btree {
	int order;
	Node root;
	
	
	public Btree(int order){
		this.root = new Node(false, true);
		this.order = order;// M 
		this.root.setfather(null);
		this.root.setkeys(new ArrayList<Integer>());
		this.root.setsons(new ArrayList<Node>());
	}
	
	
	public void index(int[] range, Node node){
		int ran = range[1]-range[0]+1;
		if(ran<=order){
			for(int i=range[0]; i<=range[1]; i++){
				node.keys.add(i);
				
				
			}
			
			node.isleaf = true;
			
		}
		
		else{
			int keyup = ran/order;
			
			int tkey = range[0];
			while(tkey+keyup<=range[1]-ran%order){
				
				
				int[] rangec = new int[2];
				rangec[0] = tkey;
//				System.out.println("ran: " + ran);
//				System.out.println("order: " + order);
//				System.out.println("rkeyup: " + keyup);
				
				if(ran%order==0)
					rangec[1] = tkey+keyup-1;
				else
					rangec[1] = tkey+keyup;
				if(rangec[1]-rangec[0]+1<=order){
//					
//					System.out.println(rangec[0]);
//					System.out.println(rangec[1]);
					
					Node newnode = new Node(true, false);
					newnode.setfather(node);
					node.sons.add(newnode);
					node.keys.add(tkey);
					index(rangec, newnode);
				}
				else{
					Node newnode = new Node(false, false);
					newnode.setfather(node);
					node.sons.add(newnode);
					node.keys.add(tkey);
					index(rangec, newnode);
				}
				if(ran%order==0)
					tkey+=keyup;
				else
					tkey+=keyup+1;
				
			}
			
			int[] rangec = new int[2];
			rangec[0] = tkey;
			rangec[1] = range[1];
			if(rangec[1]-rangec[0]+1<=order){
				Node newnode = new Node(true, false);
				newnode.setfather(node);
				node.sons.add(newnode);
				node.keys.add(tkey);
				index(rangec, newnode);
			}
			else{
				Node newnode = new Node(false, false);
				newnode.setfather(node);
				node.sons.add(newnode);
				node.keys.add(tkey);
				index(rangec, newnode);
			}
			
			
		}
			
		
		
	}
	
	
	public void lookup(int key, Node node){
		if(node.isleaf==true){
			for(int i=0; i<node.keys.size(); i++){
				System.out.println(node.keys.get(i));
				if(node.keys.get(i)==key){
					System.out.println("found");
//					System.out.println(node.datas.get(i));
					return;
						}
			}
		}
		
		
		
		else if(key>=node.getkeys().get(node.keysize()-1)){
			
			lookup(key, node.getsons().get(node.keysize()-1));
		}
		
		else{
			
			for(int i=0;i<node.keysize();i++){
				if(key<node.getkeys().get(i)){
					lookup(key, node.getsons().get(i-1));
					break;
					}
				
			}
			
		}
			
			
		
	}
}
