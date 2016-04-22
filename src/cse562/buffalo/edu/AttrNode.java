package cse562.buffalo.edu;

import java.util.ArrayList;
import java.util.List;

public class AttrNode {
	AttrNode father;
	ArrayList<AttrNode> sons;
	ArrayList<Integer> keys;
	ArrayList<Integer> index;
	boolean isleaf;
	boolean isroot;
	
	
	
	public AttrNode(boolean isleaf){
		this.isleaf = isleaf;
		keys = new ArrayList<Integer>();
		index = new ArrayList<Integer>();
		if(!isleaf)
			sons = new ArrayList<AttrNode>();
	}
	
	public AttrNode(boolean isleaf, boolean isroot){
		this(isleaf);
		this.isroot = isroot;
	}
	
	public AttrNode getfather(){
		return father;
	}
	
	public void setfather(AttrNode father){
		this.father = father;
	}
	
	public ArrayList<AttrNode> getsons(){
		return sons;
	}
	
	public void setsons(ArrayList<AttrNode> sons){
		this.sons = sons;
	}
	
	public ArrayList<Integer> getkeys(){
		return keys;
	}
	
	public void setkeys(ArrayList<Integer> keys){
		this.keys = keys;
	}
	
	
	
	
	
	
	public int keysize(){
		return this.getkeys().size();
	}

	
}
