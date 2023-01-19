package Application.cargo;

public class Iron implements Cargo{

	private int weight =0;                         //weight in tones
	static final double buyValue = 60, sellValue = 95;     
	
	public int getWeight() {return this.weight;}
	
	public void addWeight(int addedAmount) {this.weight += addedAmount; }
}
