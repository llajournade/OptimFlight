package optim;

import java.util.ArrayList;

public class Plane {
	ArrayList<Flight> flights;
	String location;
	
	public Plane() {
		this.flights = new ArrayList<Flight>();
		this.location = "";
	}

	public boolean affect(Flight flight) {
		this.flights.add(flight);
		return true;
	}
	
}
