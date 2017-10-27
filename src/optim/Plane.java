package optim;

import java.util.ArrayList;

public class Plane {
	private ArrayList<Flight> flights;
	
	public Plane() {
		this.flights = new ArrayList<Flight>();

	}
	
	public void affectFlights(ArrayList<Flight> flights) {
		for(int i=0;i<flights.size();i++) {
			if(this.affect(flights.get(i)))	flights.remove(i);
		}
	}
	private boolean canAffect(Flight flight) {
		if(this.flights.isEmpty()) {
			return true;
		} else {
			Flight lastFlight = this.flights.get(this.flights.size()-1);
			boolean checkAirport = lastFlight.getAirport_arrival().equals(flight.getAirport_departure());
			boolean checkDay = false;
			boolean checkTime = false;
			if(lastFlight.getDay() < flight.getDay()) {
				checkDay = true;
				checkTime = true;
			} else if(lastFlight.getDay() == flight.getDay()) {
				checkDay = true;
				checkTime = this.checkTime(flight,lastFlight);
			}
			
			return (checkAirport && checkDay && checkTime);
		}
	}
	private boolean checkTime(Flight flight,Flight lastFlight) {
		boolean checkTime = false;
		// The hours and minutes are on a String in the format : hours:min so we need to split it
		String[] lastFlightArrivalTimeString = lastFlight.getUtc_arrival_time().split(":");
		String[] flightDepartureTimeString = flight.getUtc_departure_time().split(":");
		//We pasrse String in int 
		int[] lastFlightArrivalTime = new int[2];
			lastFlightArrivalTime[0] = Integer.parseInt(lastFlightArrivalTimeString[0]); //hours
			lastFlightArrivalTime[1] = Integer.parseInt(lastFlightArrivalTimeString[1]); //mins
		int[] flightDepartureTime = new int[2];
			flightDepartureTime[0] = Integer.parseInt(flightDepartureTimeString[0]); //hours
			flightDepartureTime[1] = Integer.parseInt(flightDepartureTimeString[1]); //mins
		if(flightDepartureTime[0] >= lastFlightArrivalTime[0]) {
			if(flightDepartureTime[0] == lastFlightArrivalTime[0]) { // hours are equals, we need to check mins
				if(flightDepartureTime[1] > lastFlightArrivalTime[1]) { //same hours but departure mins upper than arrival mins
						checkTime = true;
				}
			} else { // Arrival time hour is lower than the departure  so is okay
				checkTime = true;
			}
		}
		return checkTime;
	}
	
	
	@Override
	public String toString() {
		return "Plane [nbFlights="+this.flights.size()+"] [flights=" + flights + "]";
	}

	public boolean affect(Flight flight) {
		if(canAffect(flight)) {
			this.flights.add(flight);
			return true;
		} else {
			return false;
		}
	}
	
}
