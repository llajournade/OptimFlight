package optim;

import java.util.Comparator;

public class DayComparator implements Comparator<Flight> {
	@Override
	public int compare(Flight a, Flight b) {
		return a.getDay() < b.getDay() ? -1 : a.getDay() == b.getDay() ? 0 : 1;
	}
}