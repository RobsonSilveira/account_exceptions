package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("\nEnter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();

			Account acc = new Account(number, holder, initialBalance, withdrawLimit);

			System.out.print("Enter amount for withdraw: ");
			Double amountWithdraw = sc.nextDouble();

			acc.withdraw(amountWithdraw);
			System.out.println("New balance: " + acc.getBalance());
		} catch (BusinessException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		} finally {
			sc.close();
		}

	}

}
