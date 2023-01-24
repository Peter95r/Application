package Application.vehicles;

public class Ship implements Transport{
	
	public final static int  capacity = 25000; //capacity of vehicle with tones
	private static final int price = 2000;

	public void deliver() {	}

	public int getCap() {return Ship.capacity;}

	@Override
	public double rentPrize(int amountOfCargo) {
		
		int numberOfShipsNeeded = (int) Math.ceil(amountOfCargo / (double) Ship.capacity); // we need x of ships to transport
		double cost = Ship.price * numberOfShipsNeeded; //every next ships is more expensive Ship.startPrize;

		System.out.println("To transport " + amountOfCargo + " tonnes by ship you needed "
				+ numberOfShipsNeeded + " ships, and transport cost was €" + cost);
		return cost;
	}
	
}
