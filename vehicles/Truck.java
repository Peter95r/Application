package Application.vehicles;

public class Truck implements Transport{
	
	public final static int  capacity = 35; //capacity of vehicle with tones
	private static final int price = 110;
	public void deliver() {}
	public int getCap() {return Truck.capacity;}
	public double rentPrize(int amountOfCargo) {
		
		int numberOfTrucksNeeded = (int) Math.ceil(amountOfCargo / (double) Truck.capacity); // we need x of trucks to transport
		double cost = Truck.price * numberOfTrucksNeeded; //every next truck is more expensive Truck.startPrize;

		System.out.println("To transport " + amountOfCargo +" tonnes by truck you needed " +
				numberOfTrucksNeeded + " trucks, and transport cost was €" + cost);
		return cost;
	}
}
