package optim;

import java.util.ArrayList;

public class FlightManagement {
	
	/**
	 * Affect flights to planes
	 * @param flights ArrayList of flights
	 * @return ArrayList of Planes affected with flights
	 */
	public ArrayList<Plane> getPlaneAffected(ArrayList<Flight> flights) {
		ArrayList<Plane> planes = new ArrayList<Plane>();
		// Browes all flights
		for(Flight flight : flights) {
			// Affect flights to planes
			affectFlight(planes,flight);
		}
		return planes;
	}
	
	
	
	private void affectFlight(ArrayList<Plane> planes, Flight flight) {
		// If it is the first affectation
		if(planes.isEmpty()) {
			Plane plane = new Plane();
			plane.affect(flight);
			planes.add(plane);
		} else {
			for(Plane plane : planes) {
				
			}
		}
	}



	/**
	 * Show all flights
	 * @param flights : ArrayList of flight
	 */
	private void showFlights(ArrayList<Flight> flights) {
		for(Flight f : flights) {
			System.out.println(f);
		}
	}
	
	public static void main(String[] args) {
		AppOptim app = new AppOptim();
		FlightManagement manager = new FlightManagement();
		try {
			//ArrayList<Flight> flights = app.readFlights();
			//manager.showFlights(flights);
		} catch (Exception e) {System.out.println(e);	}

	}

}
