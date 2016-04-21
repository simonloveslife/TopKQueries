package cse562.buffalo.edu;

public class btreeTest {
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
		Btree btree = new Btree(4);
		int n = 50;
		int[] range = new int[2];
		range[0] = 0;
		range[1] = n;
		btree.index(range, btree.root);
//		test(btree.root);
		
		
//		for(int i=1; i<100; i++){
//			
//			int[] range = new int[2];
//			range[0] = 0;
//			range[1] = i;
//			btree.index(range, btree.root);
//			System.out.println(i);
//		}
		
		for(int i=0; i<=50; i++)
			btree.lookup(i, btree.root);
		
		
		
		
		

		
		
		
	}
}
