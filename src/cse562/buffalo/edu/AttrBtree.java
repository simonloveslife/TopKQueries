package cse562.buffalo.edu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AttrBtree {
	int order;
	AttrNode root;
	
	
	public AttrBtree(int order){
		this.root = new AttrNode(false, true);
		this.order = order;// M 
		this.root.setfather(null);
		this.root.setkeys(new ArrayList<Integer>());
		this.root.setsons(new ArrayList<AttrNode>());
	}
	
	
	
	public void index(AttrElement[] element, AttrNode node){
		
		Arrays.sort(element);
		
		int ran = element.length;
		if(ran<=order){
			for(AttrElement e: element){
				node.keys.add(e.att);
				node.index.add(e.index);
				
				
			}
			node.isleaf = true;
			
		}
		
		else{
			int keyup = ran/order;
			
			int h_index = 0;
			
			while(h_index+keyup<ran-ran%order){
				
				AttrElement[] div = new AttrElement[keyup];
				for(int i=0; i<keyup; i++){
					div[i] = element[i+h_index];
					
				}
				
				if(div.length>=ran){
					
					AttrNode newnode = new AttrNode(true, false);
					newnode.setfather(node);
					node.sons.add(newnode);
					node.keys.add(element[h_index].att);
					index(div, newnode);
				}
				else{
					AttrNode newnode = new AttrNode(false, false);
					newnode.setfather(node);
					node.sons.add(newnode);
					node.keys.add(element[h_index].att);
					index(div, newnode);
				}
				
				h_index += keyup;
				
			}
			
			AttrElement[] left = new AttrElement[ran-h_index];
			for(int i=0; i<left.length; i++){
				left[i] = element[i+h_index];
				
			}
			if(left.length<=order){
				AttrNode newnode = new AttrNode(true, false);
				newnode.setfather(node);
				node.sons.add(newnode);
				node.keys.add(element[h_index].att);
				index(left, newnode);
			}
			else{
				AttrNode newnode = new AttrNode(false, false);
				newnode.setfather(node);
				node.sons.add(newnode);
				node.keys.add(element[h_index].att);
				index(left, newnode);
			}
			
		}
			
		
		
	}
	
	
	public void lookup(int key, AttrNode node){
		
//		for(int k: node.getkeys())
//			System.out.println("key: "+ k);
//		
//		System.out.println(" ");
		
		
		
		if(node.isleaf==true){
			for(int i=0; i<node.keys.size(); i++){
				
				if(node.keys.get(i)==key){
					System.out.println("found attr");
					
					int qid = node.index.get(i)+1;
					System.out.println("id is: "+ qid );
					
						}
			}
		}
		
		
		else if(key>=node.getkeys().get(node.keysize()-1)){
			lookup(key, node.getsons().get(node.keysize()-1));
			
		}
		
		else{
			
			for(int i=0;i<node.keysize()-1;i++){
				if(key>=node.getkeys().get(i)&&key<node.getkeys().get(i+1))
					lookup(key, node.getsons().get(i));
				
			}
			
		}
			
			
		
	}
	

}
