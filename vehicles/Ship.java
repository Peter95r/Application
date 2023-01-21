package Application.vehicles;

public class Ship implements Transport{
	
	public final static int  capacity = 25000; //capacity of vehicle with tones
	private static final int prize = 2000;
	public void deliver() {}
	public int getCap() {return Ship.capacity;}
	@Override
public double rentPrize(int amountOfCargo) {
		
		double x =Math.ceil(amountOfCargo / Airplane.capacity); // we need x of trucks to transport
		double cost =Ship.prize*x; //every next truck is more expensive Truck.startPrize;

		System.out.println("To transport " + amountOfCargo +" you will need " + x + " trucks, and it will cost: " + cost);
		return cost;
	}
	
}
