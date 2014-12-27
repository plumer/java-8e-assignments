import java.util.*;

public class SetListPerformanceTest {
	private static int size = 250000;
	public static void main(String [] ars ) {
		Collection<Integer> set1 = new HashSet<Integer>();
		System.out.println("Time for hash set is " +
			getTestTime(set1, size) + " milliseconds");
		Collection<Integer> set2 = new LinkedHashSet<Integer>();
		System.out.println("Time for linked hash set is " +
			getTestTime(set2, size) + " milliseconds");
		Collection<Integer> set3 = new TreeSet<Integer>();
		System.out.println("Time for tree set is " +
			getTestTime(set3, size) + " milliseconds");	

		Collection<Integer> set4 = new ArrayList<Integer>();
		System.out.println("Time for array list is " +
			getTestTime(set4, size) + " milliseconds");	

		Collection<Integer> set5 = new LinkedList<Integer>();
		System.out.println("Time for linked list is " +
			getTestTime(set4, size) + " milliseconds");
	}

	public static long getTestTime(Collection<Integer> c, int size) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++)
			list.add(i);
		Collections.shuffle(list);

		long startTime = System.currentTimeMillis();
		for(int element: list)
			c.add(element);
		
		Collections.shuffle(list);

		for(int element: list)
			c.remove(element);

		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
