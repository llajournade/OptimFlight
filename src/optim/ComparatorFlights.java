package optim;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorFlights {
	public static void sortFlights(ArrayList<Flight> f) {
		Collections.sort(f, new DayComparator());
	}
}
