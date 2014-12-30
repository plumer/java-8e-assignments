/** The iterator is fail-fast.
 * Write a program to demonstrate it by creating two threads that
 *   concurrently access and modify a set.
 * The first thread creates a hash set filled with numbers,
 *   and adds a new number to the set every second.
 * The second thread obtains an iterator for the set 
 *   and traverses the set back and forth throught the iterator every second.
 * You will receive a ConcurrentModificationException 
 *   because the underlying set is being modified in the first thread
 *   while the set in the second thread is being traversed.
 */

import java.util.*;

public class Conflict {
	public static void main(String [] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		Runnable p = new Producer(set);
		Runnable c = new Consumer(set);
		Thread pTh = new Thread(p);
		Thread cTh = new Thread(c);

		pTh.start();
		cTh.start();
	}
}

class Producer implements Runnable {
	Set s;
	public Producer(Set<Integer> s) {
		this.s = s;
	}

	public void run() {
		try {
			int i = 0;
			while (true) {
				s.add(i);
				i++;
				Thread.sleep(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
class Consumer implements Runnable {
	Set s;
	public Consumer(Set<Integer> s) {
		this.s = s;
	}

	public void run() {
		try {
			while (true) {
				Iterator<Integer> iterator = s.iterator();
				while (iterator.hasNext()) {
					Integer i = iterator.next();
				}
				Thread.sleep(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
