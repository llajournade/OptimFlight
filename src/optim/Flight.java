package optim;


/**
 * Vol.
 */
public class Flight
{
	/*------------*/
	/* Propriétés */
	/*------------*/

    private String airport_departure;	// Aéroport de départ
    private String airport_arrival;		// Aéroport d'arrivée
    private int day;					// Jour de la semaine : 1 -> Lundi ... 7 -> Dimanche
    private String utc_departure_time;	// Heure de départ
    private String utc_arrival_time;	// Heure d'arrivée


	/*----------*/
	/* Méthodes */
	/*----------*/

    public String getAirport_departure () { return this.airport_departure; }

    public void setAirport_departure (String airport_departure) { this.airport_departure = airport_departure; }

    public String getAirport_arrival () { return this.airport_arrival; }

    public void setAirport_arrival (String airport_arrival) { this.airport_arrival = airport_arrival; }

	public int getDay () { return this.day; }

    public void setDay (int day) { this.day = day; }

    public String getUtc_departure_time () { return this.utc_departure_time; }

    public void setUtc_departure_time (String utc_departure_time) { this.utc_departure_time = utc_departure_time; }

    public String getUtc_arrival_time( ) { return this.utc_arrival_time; }

    public void setUtc_arrival_time (String utc_arrivatime) { this.utc_arrival_time = utc_arrivatime; }


	@Override
	public String toString ()
		{
		StringBuilder sb = new StringBuilder();
		sb.append(this.airport_departure).append(';')
		  .append(this.airport_arrival).append(';')
		  .append(this.day).append(';')
		  .append(this.utc_departure_time).append(';')
		  .append(this.utc_arrival_time);

		return sb.toString();
		}

} /*----- Fin de la classe -----*/
