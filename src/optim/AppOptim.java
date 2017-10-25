package optim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 */
public class AppOptim
{
	/*------------*/
	/* Propriétés */
	/*------------*/

	/*----- Nom du fichier de données -----*/
	private static String FICHIER = "zone_1";
//	private static String FICHIER = "zone_2";

	/*----- Temps durant lequel un avion ne peut pas redécoller -----*/
	private static int TURN_AROUND = 10; // Pour la zone 1
//	private static int TURN_AROUND = 50; // Pour la zone 2


	/*---------------------*/
	/* Programme principal */
	/*---------------------*/

    public static void main(String[] args) throws IOException
		{
		System.out.println("Fichier de données : " + FICHIER);

		/*----- Chargement de la liste des vols -----*/
		ArrayList<Flight> flights = readFlights();
		System.out.println("Nombre de vols " + flights.size());

		System.out.println("----- Liste des vols -----");
		for (Flight flight : flights)
			System.out.println(flight);
		System.out.println("----- Fin de la liste des vols -----");
		}


	/*----------*/
	/* Méthodes */
	/*----------*/

	/**
	 * Lecture du fichier de données des vols à planifier.
	 */
	public static ArrayList<Flight> readFlights () throws IOException
		{
		ArrayList<Flight> flights = new ArrayList();
		Flight f;
		try (BufferedReader fichier_source = new BufferedReader(new FileReader(FICHIER + ".csv")))
			{
			String s;
			while((s = fichier_source.readLine()) != null)
				{
				String[] flightLine = s.split(";");
				String days = flightLine[2];
				for (int d=1; d<8; d++)
					{
					if (days.contains(String.valueOf(d)))
						{
						f = new Flight();
						f.setAirport_departure(flightLine[0]);
						f.setAirport_arrival(flightLine[1]);
						f.setDay(d);
						f.setUtc_departure_time(flightLine[3]);
						f.setUtc_arrival_time(flightLine[4]);
						flights.add(f);
						}
					}
				}
			}

		return flights;
		}
	
	/**
	 * Sauvegarde de la solution.
	 */
	public static boolean save (String path, String nomBench, String nomEtudiant, ArrayList<ArrayList<Flight>> solution)
		{
		File rep = new File(path);
		if (!rep.exists()) rep.mkdirs();

		PrintWriter out;
		try {
			out = new PrintWriter(path + File.separatorChar + nomBench + "_" + nomEtudiant + "_result.txt", "ISO-8859-1");

			/*----- Nombre d'avions -----*/
			out.println(solution.size());

			/*----- Nombre de vols par avion -----*/
			for (ArrayList<Flight> avion : solution)
				out.println(avion.size());

			/*----- Ecriture des vols -----*/
			for (ArrayList<Flight> avion : solution)
				for (Flight vol : avion)
					{
					out.println(vol.getAirport_departure() + ";" +
								vol.getAirport_arrival() + ";" +
								vol.getDay() + ";" +
								vol.getUtc_departure_time() + ";" +
								vol.getUtc_arrival_time()
								);
					}

			out.close();

			return true;
			}
		catch (IOException e) { return false; }
		}

} /*----- Fin de la classe -----*/
