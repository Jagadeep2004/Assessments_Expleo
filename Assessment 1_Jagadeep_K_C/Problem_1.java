package Programs;

import java.util.Scanner;

public class Problem_1 {
	public static int sumOfDigits(int n) {
		 while (n >= 10) {          
	            int sum = 0;

	            while (n > 0) {         
	                sum += n % 10;
	                n /= 10;
	            }

	            n = sum;                
	        }
	        return n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number : ");
		int number = sc.nextInt();
		
		int[] arr = new int[number];
		int[] vals = new int[number];
		for(int i =0 ;i < number ;i++) {
			arr[i] = sc.nextInt();
			vals[i] = sumOfDigits(arr[i]);
		}
		
		int count = 0;
		for(int i = 0;i < number;i++) {
			if(count == 3) {
				break;
			}
			if(vals[i] == 7) {
				System.out.print("First Prize is to token:"+arr[i]);
			}
			else if(vals[i] == 5) {
				System.out.print("First Prize is to token:"+arr[i]);
			}
			else if(vals[i] == 3) {
				System.out.print("First Prize is to token:"+arr[i]);
			}
		}
		sc.close();
	}

}
