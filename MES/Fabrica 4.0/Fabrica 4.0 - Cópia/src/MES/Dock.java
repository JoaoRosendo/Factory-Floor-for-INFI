package MES;

public class Dock {
	short[] nr_types;
	short total;
	public Dock(short[] nr_types, short total) {
		super();
		this.nr_types = nr_types;
		this.total = total;
	}
	public short[] getNr_types() {
		return nr_types;
	}
	public void setNr_types(short[] nr_types) {
		this.nr_types = nr_types;
	}
	public short getTotal() {
		return total;
	}
	public void setTotal(short total) {
		this.total = total;
	}
}
