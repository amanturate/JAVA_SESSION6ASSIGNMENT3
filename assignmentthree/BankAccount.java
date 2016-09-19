package assignmentthree;

public class BankAccount {

	int accountNumber;

	double accountBalance;

	public BankAccount(int accountNumber, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	// to withdraw funds from the account
	public synchronized void transferSync(double amount)
			throws InterruptedException {
		double newAccountBalance;

		if (amount > accountBalance) {
			// there are not enough funds in the account
			System.out.println("You have Insufficient Balance. Transaction cancelled.");
			
		}

		else {
			newAccountBalance = accountBalance - amount;
			Thread.sleep(1000);
			accountBalance = newAccountBalance;
			System.out.println(amount + " has been succesfully transferred");
		}

	}

	public void transferNonSync(double amount) throws InterruptedException {
		double newAccountBalance;

		if (amount > accountBalance) {
			// there are not enough funds in the account
			System.out.println("You have Insufficient Balance. Transaction cancelled.");
			;
		}

		else {
			newAccountBalance = accountBalance - amount;
			Thread.sleep(1000);
			accountBalance = newAccountBalance;
			System.out.println(amount + " has been succesfully Transferred");
		}

	}

	public synchronized void depositSync(double amount)
			throws InterruptedException {
		double newAccountBalance;

		if (amount < 0.0) {
			System.out.println("You Cannot Deposit Negative Amount");
			 // can not deposit a negative amount
		}

		else {
			newAccountBalance = accountBalance + amount;
			Thread.sleep(1000);
			accountBalance = newAccountBalance;
			System.out.println(amount + " has been succesfully deposited");
		}
	}

	public void depositNonSync(double amount) throws InterruptedException {
		double newAccountBalance;

		if (amount < 0.0) {
			System.out.println("You Cannot Deposit Negative Amount");
		}

		else {
			newAccountBalance = accountBalance + amount;
			Thread.sleep(1000);
			accountBalance = newAccountBalance;
			System.out.println(amount + " has been succesfully deposited");
		}
	}
}
