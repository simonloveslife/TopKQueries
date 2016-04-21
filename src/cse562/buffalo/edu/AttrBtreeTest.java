package cse562.buffalo.edu;

public class AttrBtreeTest {
	
	private static void test(Node node){
		if(!node.isleaf){
			for(Node son: node.sons){
				
				
				
				
				test(son);
				
				
			}
		}
		
		else{
			for(Integer i: node.keys){
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("'");
		}
			
	}
	
	
	public static void main(String[] args){
		
		
//		AttrBtree Attrbtree = new AttrBtree(4);
//		int n = 10;
//		int[] element = new int[n];
//		for(int i=0; i<n; i++)
//			element[i] = (int)(Math.random()*100);
//		
//		
//		Attrbtree.index(element, Attrbtree.root);
//		test(Attrbtree.root);
		
		
		AttrBtree Attrbtree = new AttrBtree(4);
		int n = 50;
		int[] element = new int[n];
		for(int i=0; i<50; i++)
			element[i] = i;
		
		element[40] = 25;
		Attrbtree.index(element, Attrbtree.root);
//		test(Attrbtree.root);
		Attrbtree.lookup(25, Attrbtree.root);
		
		
		
		
	}
}
