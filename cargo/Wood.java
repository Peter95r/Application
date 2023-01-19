package Application.cargo;

public class Wood implements Cargo{

	private int weight =0;                 //weight in tones
	static final int sellValue = 65;    //95 euro per metric tone
	// static final buyValue = 40;      future feature when we going to fill the warehouse
	
	
	public int getWeight() {return this.weight;}
	
	public void addWeight(int addedAmount) {this.weight += addedAmount; }
}
