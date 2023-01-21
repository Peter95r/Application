package Application.vehicles;

public class Ship implements Transport{
	
	public final static int  capacity = 25000;     //capacity of vehicle with tones
	public void deliver() {}
	public int getCap() {return Ship.capacity;}
}
