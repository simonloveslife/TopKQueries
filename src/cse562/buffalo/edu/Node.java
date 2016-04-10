package cse562.buffalo.edu;

import java.util.ArrayList;


public class Node {
	Node father;
	ArrayList<Node> sons;
	ArrayList<Integer> keys;
	
	public Node(int order) {
		this.sons = new ArrayList<Node>(order);
		this.keys = new ArrayList<Integer>(order - 1);
	}

	
}
