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
		ComparatorFlights.sortFlights(flights);
		// Browes all flights
		for(Flight flight : flights) {
			// Affect flights to planes
			affectFlight(planes,flight);
		}
		return planes;
	}
	
	public ArrayList<Plane> getPlaneAffected2(ArrayList<Flight> flights) {
		ArrayList<Plane> planes = new ArrayList<Plane>();
		ComparatorFlights.sortFlights(flights);
		while(!flights.isEmpty()) {
			Plane plane = new Plane();
			plane.affectFlights(flights);
			planes.add(plane);
		}
		return planes;
	}
	
	private void affectFlight(ArrayList<Plane> planes, Flight flight) {
		// If it is the first affectation
		boolean isAffected = false;
		for(Plane plane : planes) {
			if(plane.affect(flight)) {
				isAffected=true;
				return;
			}
		}
		if(planes.isEmpty() || !isAffected) {
			Plane plane = new Plane();
			plane.affect(flight);
			planes.add(plane);
			isAffected=true;
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
	
	private void showPlanes(ArrayList<Plane> planes) {
		for(Plane plane : planes) {
			System.out.println(plane);
		}		
	}
	public static void main(String[] args) {
		AppOptim app = new AppOptim();
		FlightManagement manager = new FlightManagement();
		try {
			ArrayList<Flight> flights = app.readFlights();
			ArrayList<Plane> planes = manager.getPlaneAffected(flights);
			System.out.println("Nombre de vols :"+flights.size());
			System.out.println("Nombre d'avions :"+planes.size());
			//manager.showFlights(flights);
			//manager.showPlanes(planes);
		} catch (Exception e) {System.out.println(e);	}
	}
}
