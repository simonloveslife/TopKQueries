package cse562.buffalo.edu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AttrBtree {
	int order;
	Node root;
	
	
	public AttrBtree(int order){
		this.root = new Node(false, true);
		this.order = order;// M 
		this.root.setfather(null);
		this.root.setkeys(new ArrayList<Integer>());
		this.root.setsons(new ArrayList<Node>());
	}
	
	
	
	public void index(int[] element, Node node){
		
		Arrays.sort(element);
		
		int ran = element.length;
		if(ran<=order){
			for(int e: element){
				node.keys.add(e);
				
				
			}
			node.isleaf = true;
			
		}
		
		else{
			int keyup = ran/order;
			
			int h_index = 0;
			
			while(h_index+keyup<ran-ran%order){
				
				int[] div = new int[keyup];
				for(int i=0; i<keyup; i++){
					div[i] = element[i+h_index];
					
				}
				
				if(div.length>=ran){
					
					Node newnode = new Node(true, false);
					newnode.setfather(node);
					node.sons.add(newnode);
					node.keys.add(element[h_index]);
					index(div, newnode);
				}
				else{
					Node newnode = new Node(false, false);
					newnode.setfather(node);
					node.sons.add(newnode);
					node.keys.add(element[h_index]);
					index(div, newnode);
				}
				
				h_index += keyup;
				
			}
			
			int[] left = new int[ran-h_index];
			for(int i=0; i<left.length; i++){
				left[i] = element[i+h_index];
				
			}
			if(left.length<=order){
				Node newnode = new Node(true, false);
				newnode.setfather(node);
				node.sons.add(newnode);
				node.keys.add(h_index);
				index(left, newnode);
			}
			else{
				Node newnode = new Node(false, false);
				newnode.setfather(node);
				node.sons.add(newnode);
				node.keys.add(h_index);
				index(left, newnode);
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
