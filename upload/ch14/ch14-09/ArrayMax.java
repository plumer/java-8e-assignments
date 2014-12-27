// Java Programming Assignment 14.9
// Implemen the given method max(Comparable [] a)
// Written by 121220130

import java.util.Date;

public class ArrayMax {
	public static Object max( Comparable[] a ) {
		if (a.length == 0) return new Object();
		Object m = a[0];
		for (int i = 1; i < a.length; ++i)
			if (a[i].compareTo(m) > 0) m = a[i];
		return m;
	}

	public static void main( String[] args ) {
		String [] stringArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
		Integer [] intArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
		Date [] dateArray = {
			new Date(1900, 1, 1), new Date(1990, 1, 1), new Date(1960, 1, 1)
		};

		System.out.println( (String)(max(stringArray)) );
		System.out.println( (Integer)(max(intArray)) );
		System.out.println( (Date)(max(dateArray)) );
	}
}
