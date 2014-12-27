import java.util.*;

public class TestTreeSet {
	public static void main (String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing");
		set.add("New York");

		TreeSet<String> treeSet = new TreeSet<String>(set);
		// copied all elements from set to treeset
		System.out.println("Sorted tree set: " + treeSet);

		System.out.println("first(): " + treeSet.first());
		System.out.println("last(): "  + treeSet.last());
		System.out.println("headSet(): " + treeSet.headSet("New York"));
		System.out.println("tailSet(): " + treeSet.tailSet("New York"));

		System.out.println("lower(\"P\"): " + treeSet.lower("P"));

		System.out.println("higher(\"P\"): " + treeSet.higher("P"));
		System.out.println(treeSet.floor("P"));
		System.out.println(treeSet.ceiling("P"));
		System.out.println(treeSet.pollFirst());
		System.out.println(treeSet.pollLast());
		System.out.println(treeSet);
	}
}
