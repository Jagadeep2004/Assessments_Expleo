/*
 * Get a number from user and determine whether it is a perfect number or not.
 */
package Programs;

import java.util.Scanner;

public class Problem_3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Getting input from users
		System.out.print("Enter a positive integer: ");
		int number = sc.nextInt();
		int sum =0;
		
		//Identifying the i value which are divisors of number
		for(int i = 1;i < number;i++) {
			if(number % i ==0) {
				sum += i;
			}
		}
		
		//Checking whether the sum of divisor is equal to number
		if(sum == number) {
			System.out.println("The given number is perfect");
		}
		else {
			System.out.println("The given number is not perfect");
		}
		sc.close();
	}

}
