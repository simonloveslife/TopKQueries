package cse562.buffalo.edu;

import java.util.ArrayList;
import java.util.List;


public class Node {
	Node father;
	ArrayList<Node> sons;
	ArrayList<Integer> keys;
	ArrayList<List<String>> datas;
	boolean isleaf;
	boolean isroot;
	
	
	
	public Node(boolean isleaf){
		this.isleaf = isleaf;
		keys = new ArrayList<Integer>();
		datas = new ArrayList<List<String>>();
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
		return datas;
	}
	
	
	
	
	public int keysize(){
		return this.getkeys().size();
	}

	
}
