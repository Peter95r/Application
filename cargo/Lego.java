package Application.cargo;

public class Lego implements Cargo{

	private int weight =0;                         //weight in tones
	static final int sellValue = 115;    //95 euro per metric tone
	// static final buyValue = 70;      future feature when we going to fill the warehouse
	
	public int getWeight() {return this.weight;}
	
	public void addWeight(int addedAmount) {this.weight += addedAmount; }
}
