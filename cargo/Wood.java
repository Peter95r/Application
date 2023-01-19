package Application.cargo;

public class Wood implements Cargo{

	private int weight =0;                 //weight in tones
	static final double buyValue = 40, sellValue = 65;     
	
	
	public int getWeight() {return this.weight;}
	
	public void addWeight(int addedAmount) {this.weight += addedAmount; }
}
