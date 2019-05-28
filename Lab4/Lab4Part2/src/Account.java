/*
 * Name: Sheharyar Alam Khan
 * Lab 4 Part 2
 * Professor Gao
 * 05/08/19
 * CS-170-02
 * Description:
 * This is the method class which has all of the back end part of the program. it uses three synchronized functions so that only one thread runs at a time.
 * The synchronized keyword ensure that only one thread is run at a time.
 * the wait(long) function makes does the task and gives up control to the other thread.
 */
public class Account {
	//member variable
	double balance = 1000.0;
	//prints out the balance
	public synchronized void balance()
	{
		System.out.printf("Balance: $%.2f.\n", balance);
		return;
	}
	//deposit money to the account increasing its balance. it also takes in the String user to help track who is making the transaction.
	public synchronized void deposit(double amount, String user) {
		try {
			wait(200);//taking 0.2sec to do the transaction
			balance += amount;
			System.out.printf(user + "depositing $%.2f. New Balance: $%.2f.\n", amount, balance);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	//withdraw money from the account decreasing its balance. it also takes in the String user to help track who is making the transaction.
	public synchronized boolean withdraw(double amount, String user) {
		if(amount > balance)
			return (false);
		else
		{
			try {
				wait(500);//taking 0.5sec to do the transaction
				balance -= amount;
				System.out.printf(user + "Withdrawing $%.2f. New Balance: $%.2f.\n", amount, balance);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return (true);
	}
}
