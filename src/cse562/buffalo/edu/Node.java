package cse562.buffalo.edu;

import java.util.ArrayList;


public class Node {
	Node father;
	ArrayList<Node> sons;
	ArrayList<Integer> keys;
	Object data;
	boolean isleaf;
	boolean isroot;
	
	public Node(boolean isleaf){
		this.isleaf = isleaf;
		keys = new ArrayList<Integer>();
		data = new Object();
		if(!isleaf)
			sons = new ArrayList<Node>();
	}
	
	public Node(boolean isleaf, boolean isroot){
		this(isleaf);
		this.isroot = isroot;
	}
	
	public Node getfather(){
		return father;
	}
	
	public void setfather(Node father){
		this.father = father;
	}
	
	public ArrayList<Node> getsons(){
		return sons;
	}
	
	public void setsons(ArrayList<Node> sons){
		this.sons = sons;
	}
	
	public ArrayList<Integer> getkeys(){
		return keys;
	}
	
	public void setkeys(ArrayList<Integer> keys){
		this.keys = keys;
	}
	
	public Object getdata(){
		return data;
	}
	
	public void setdata(Object data){
		this.data =data;
	}
	
	
	public int keysize(){
		return this.getkeys().size();
	}

	
}
