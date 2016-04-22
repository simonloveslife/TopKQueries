package cse562.buffalo.edu;

public class AttrElement implements Comparable<AttrElement> {
	int att;
	int index;
	public AttrElement(int att, int index){
		this.att = att;
		this.index = index;
		
		
	}
	
	public AttrElement(){
		this.att = 0;
		this.index = 0;
		
		
	}
	
	public void set_att(int att){
		this.att = att;
	}
	
	public int get_att(){
		return this.att;
	}
	
	public void set_index(int index){
		this.index = index;
	}
	
	public int get_index(){
		return this.index;
	}
	
	
	@Override
	public int compareTo(AttrElement o) {
		
		return (int)(this.att - o.att);
	}
}
