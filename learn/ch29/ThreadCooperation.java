import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ThreadCooperation {
	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		System.out.println("Thread1\t\t\tThread2\t\t\tBalance");
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();

	}

	public static class DepositTask implements Runnable {
		public void run() {
			try {
				while (true) {
					account.deposit( (int)(Math.random() * 10) + 1);
					Thread.sleep(1000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		} // end of DepositaTask.run()
	} // end of DepositTask
	
	public static class WithdrawTask implements Runnable {
		public void run() {
			try {
				while (true) {
					account.withdraw( (int)(Math.random() * 10) + 1);
					Thread.sleep( 700 );
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	} // end of WithdrawTask

	private static class Account {
		private static Lock lock = new ReentrantLock();
		private static Condition newDeposit = lock.newCondition();

		private int balance = 0;

		public int getBalance () {
			return balance;
		}

		public void withdraw(int amount) {
			lock.lock();
			try {
				while (balance < amount) {
					System.out.println("\t\t\tWait for a deposit: " + amount);
					newDeposit.await();
				}

				balance -= amount;
				System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally {
				lock.unlock();
			}
		} // end of Account.withdraw

		public void deposit(int amount) {
			lock.lock();
			try {
				balance += amount;
				System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
				newDeposit.signalAll();
				// signal threads
			} finally {
				lock.unlock();
			}
		} // end of Account.deposit()
	}
}

