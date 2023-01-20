package Application.cargo;

public class Lego implements Cargo{

	private int weight =0;                         //weight in tones
	public  static final double buyValue = 70, sellValue = 115;        
	
	public int getWeight() {return this.weight;}
	
	public void addWeight(int addedAmount) {this.weight += addedAmount; }
}
