package Application.vehicles;

public class Airplane implements Transport{
	
	public final static int  capacity = 140; 
	private static final int prize = 400;//capacity of vehicle with tones
	public void deliver() {}
	public int getCap() {return Airplane.capacity;}
	@Override
public double rentPrize(int amountOfCargo) {
		
		double x =Math.ceil(amountOfCargo / Airplane.capacity); // we need x of trucks to transport
		double cost =Airplane.prize*x; //every next truck is more expensive Truck.startPrize;

		System.out.println("To transport " + amountOfCargo +" you will need " + x + " trucks, and it will cost: " + cost);
		return cost;
	}
	
}
