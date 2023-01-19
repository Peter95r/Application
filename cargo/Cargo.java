
/*
 * For now there is only one material to sell,  I think it is good idea to extend it later on.
 * */


package Application.cargo;

public interface Cargo {
	
}

class Iron implements Cargo{
	
	int weight;                         //weight in tones
	static final int sellValue = 95;    //95 euro per metric tone
	// static final buyValue = 60;      future feature when we going to fill the warehouse
	
}
