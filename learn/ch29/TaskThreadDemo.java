public class TaskThreadDemo {
	public static void main(String [] args) {

		Runnable printA = new PrintChar('a', 233);
		Runnable printB = new PrintChar('b', 79);
		Runnable print100 = new PrintNum(100);

		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);

		thread1.start();
		thread2.start();
		thread3.start();
	}
}

class PrintChar implements Runnable {
	private char charToPoint;
	private int times;

	public PrintChar(char c, int t) {
		charToPoint = c;
		times = t;
	}

	// override the run() method to tell the system what task to perform
	public void run() {
		try {
			for (int i = 0; i < times; ++i) {
				System.out.print(charToPoint);
				Thread.sleep(times);
				Thread.yield();
			}
		} catch (InterruptedException ex) {
			System.out.println("\n" + charToPoint + " interrupted");
		}
	}
}

class PrintNum implements Runnable {
	private int lastNum;

	public PrintNum(int n) {
		lastNum = n;
	}

	public void run() {
		try {
			for (int i = 1; i <= lastNum; ++i) {
				System.out.print(" " + i);
				Thread.sleep(137);
			}
		} catch (InterruptedException ex) {
			System.out.println("\n" + lastNum + " interrupted");
		}
	}
}
