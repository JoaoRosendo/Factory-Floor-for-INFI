package MES;

public class Dock {
	static short[] nr_types;
	static short total;
	public static short[] getNr_types() {
		return nr_types;
	}
	public static void setNr_types(short[] nr_types) {
		Dock.nr_types = nr_types;
	}
	public static short getTotal() {
		return total;
	}
	public static void setTotal(short total) {
		Dock.total = total;
	}
}
