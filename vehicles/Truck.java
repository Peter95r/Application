package Application.vehicles;

public class Truck implements Transport{
	
	public final static int  capacity = 35;//capacity of vehicle with tones
	private static final int prize = 110;
	public void deliver() {}
	public int getCap() {return Truck.capacity;}
	public double rentPrize(int amountOfCargo) {
		
		double x =Math.ceil(amountOfCargo / Truck.capacity); // we need x of trucks to transport
		double cost =Truck.prize*x; //every next truck is more expensive Truck.startPrize;

		System.out.println("To transport " + amountOfCargo +" you will need " + x + " trucks, and it will cost: " + cost);
		return cost;
	}
}
