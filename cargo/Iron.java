package Application.cargo;

public class Iron implements Cargo{

	private int weight =0;                         //weight in tones
	static final int sellValue = 95;    //95 euro per metric tone
	// static final buyValue = 60;      future feature when we going to fill the warehouse
	
	public int getWeight() {return this.weight;}
	
	public void addWeight(int addedAmount) {this.weight += addedAmount; }
}
