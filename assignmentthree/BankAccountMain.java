package assignmentthree;

import java.util.ArrayList;
import java.util.List;

public class BankAccountMain {
	static List<Thread> threadList = new ArrayList<Thread>();

	static BankAccount ba1 = new BankAccount(1001, 15000);
	static BankAccount ba2 = new BankAccount(1002, 30000);

	public static void main(String[] args) throws Exception {

		Thread t1 = new Thread() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					ba1.depositSync(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					ba1.depositSync(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread t3 = new Thread() {
			public void run() {
				// TODO Auto-generated method stub

				try {
					ba2.depositNonSync(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};

		Thread t4 = new Thread() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					ba2.depositNonSync(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t5 = new Thread() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					ba1.transferSync(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t6 = new Thread() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					ba1.transferSync(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t7 = new Thread() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					ba2.transferNonSync(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t8 = new Thread() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					ba2.transferNonSync(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		

		t1.start();
		threadList.add(t1);
		t2.start();
		threadList.add(t2);
		t3.start();
		threadList.add(t3);
		t4.start();
		threadList.add(t4);
		
		for(Thread t : threadList) {
	          // waits for this thread to die
	          t.join();
	      }
		System.out.println("The Acoount Balance for " + ba1.accountNumber + " is (using Synchronised) after deposit " + ba1.accountBalance);
		System.out.println("The Acoount Balance for " + ba2.accountNumber + " is (using Non Synchronised) after deposit " + ba2.accountBalance);
		System.out.println("###################################");
		System.out.println("###################################");
		
		t5.start();
		threadList.add(t5);
		t6.start();
		threadList.add(t6);
		t7.start();
		threadList.add(t7);
		t8.start();
		threadList.add(t8);
		for(Thread t : threadList) {
	          // waits for this thread to die
	          t.join();
	      }
		System.out.println("The Acoount Balance for " + ba1.accountNumber + " is (using Synchronised) after transfer " + ba1.accountBalance);
		System.out.println("The Acoount Balance for " + ba2.accountNumber + " is (using Non Synchronised) after transfer " + ba2.accountBalance);

	}
}
