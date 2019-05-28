/*
 * Name: Sheharyar Alam Khan
 * Lab 4 Part 2
 * Professor Gao
 * 05/08/19
 * CS-170-02
 * Description:
 * This is the driver class and in this class I am making two Threads and they are husband and wife. In this program I am
 * generating two random numbers. One for deposit and second for withdrawal. Both of these random numbers are implemented 
 * to both of the Threads. It will run until it satisfies the condition in the for loop.
 */
import java.util.Random;

public class MultiThreadApp {

	public static void main(String[] args) {
		Account acc = new Account(); // makes new account
		// TODO Auto-generated method stub
		Thread husband = new Thread(new Runnable() { //new thread with overridden run function.
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 50; i++) {
					Random r1 = new Random();
					int op = (r1.nextInt() % 2) + 1; // sets op to either 1 or 2 randomly.
					Random r2 = new Random();
					int amount = (r2.nextInt() % 250) + 1;// sets amount to a random integer between 1 and 250.
					if(amount < 0)
						amount = -amount;//if amount is negative make it positive.
				try {
					if(op == 1) {
						acc.deposit(amount, "Husband: ");//calls synchronized function
					}
					else if(op == 2) {
						acc.withdraw(amount, "Husband: ");//calls synchronized function
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				}
			}
		});
		Thread wife = new Thread(new Runnable() {//exactly the same as the husband thread above.
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 50; i++) {
					Random r1 = new Random();
					int op = (r1.nextInt() % 2) + 1;
					Random r2 = new Random();
					int amount = (r2.nextInt() % 250) + 1;
					if(amount < 0)
						amount = -amount;
					try {
						if(op == 1) {
							acc.deposit(amount, "Wife: ");//calls synchronized function
						}
						else if(op == 2) {
							acc.withdraw(amount, "Wife: ");//calls synchronized function
						}
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
		});
		//starting threads
		husband.start();
		wife.start();
		
		try {
			//joining threads
			husband.join();
			wife.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//prints the balance to the console
		acc.balance();
	}

}
