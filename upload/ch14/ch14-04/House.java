// Java Programming Assignment 14.04
// Polish listing 14.9 to perform a DEEP COPY in House.clone() function.
// Modified by 121220130

public class House implements Cloneable, Comparable {
	private int id;
	private double area;
	private java.util.Date whenBuilt;

	public House(int id, double area) {
		this.id = id;
		this.area = area;
		whenBuilt = new java.util.Date();
	}

	public int getId() {
		return id;
	}

	public double getArea() {
		return area;
	}

	public java.util.Date getWhenBuilt() {
		return whenBuilt;
	}

	/** Override the protected clone method defined in the Object class,
	 * and strengthen its accessibility */
	@Override public Object clone() throws CloneNotSupportedException {
		/*return super.clone();*/ // original code
		House house = (House)super.clone();
		house.whenBuilt = (java.util.Date)(this.whenBuilt.clone());
		return house;
	}

	public int compareTo(Object o) {
		if (area > ( (House) o ).area) 
			return 1;
		else if (area < ( (House)o ).area)
			return -1;
		else
			return 0;
	}

	public static void main( String [] args ) {
		House h1 = new House(1, 100);
		try {
			House h2 = (House)(h1.clone());
			System.out.println(h2.getId() + " " + h2.getArea() + " " + h2.getWhenBuilt());
			System.out.println(h2.getWhenBuilt() == h1.getWhenBuilt());
			System.out.println(h2.getWhenBuilt().hashCode() == h1.getWhenBuilt().hashCode());
		} catch (CloneNotSupportedException e) {
			System.out.println("Clone not supported");
		}
	}
}
