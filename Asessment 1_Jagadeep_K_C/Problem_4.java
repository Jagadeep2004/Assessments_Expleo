/*
 * To get start and end value from user and to display the values and whenever 5th and 10th value occurs "ding" and "dong" need to 
 * be printed
 */
package Programs;

import java.util.Scanner;

public class Problem_4 {
	
	//Function to print values and ding dong
	public static void dingDong(int start,int end) {
		int count =0;
		
		for(int i = start;i <= end;i++) {
			count++;
			if(count == 5) {
				System.out.print("ding ");
			}
			else if(count == 10) {
				System.out.print("dong ");
				count = 0;
			}
			else {
				System.out.print(i+" ");
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Getting input from user
		System.out.print("Starting number : ");
		int start = sc.nextInt();
		System.out.print("Ending number :");
		int end = sc.nextInt();
		
		//Calling dinDong function
		dingDong(start,end);
		
		sc.close();

	}

}
