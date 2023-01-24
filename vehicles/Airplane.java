package Application.vehicles;

public class Airplane implements Transport{
	
	public final static int capacity = 140;
	private static final int price = 400;//capacity of vehicle with tones

	public void deliver() {}

	public int getCap() {return Airplane.capacity;}

	@Override
    public double rentPrize(int amountOfCargo) {
		
		int numberOfPlanesNeeded = (int) Math.ceil(amountOfCargo / (double) Airplane.capacity); // we need x of trucks to transport
		double cost = Airplane.price * numberOfPlanesNeeded; //every next plane is more expensive Truck.startPrize;

		System.out.println("To transport " + amountOfCargo +" tonnes by plane you needed "
				+ numberOfPlanesNeeded + " planes, and transport cost was €" + cost);
		return cost;
	}
	
}
