package Application.vehicles;

public interface Transport {

	void deliver();
	default int getCap() {return 0;}
}
