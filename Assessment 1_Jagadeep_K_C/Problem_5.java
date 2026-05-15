/*
 * Allocating marks for students based on the requirements
 */
package Programs;

import java.util.Scanner;

public class Problem_5 {
	//Func to allocate result
	public static int enterScore(int val) {
		
		int result =0;
		
		if(val % 2 != 0 || val % 8 != 0 || val % 10 != 3 || val % 9 != 0) {
			result = 1;
		}
		if(val % 2 == 0) {
			result = 0;
		}
		if(val % 8 == 0) {
			result = 2;
		}
		if(val % 10 == 3) {
			result = 3;
		}
		if(val % 9 == 0) {
			result = 4;
		}
			
			
			return result;
		}
		
		
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int[] arr = new int[10];
		
		//Calling func with loop
		for(int i = 0;i < arr.length;i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < 0) {
				arr[i] = 0;
				break;
			}
			System.out.print(enterScore(arr[i])+" ");
		}
		sc.close();
	}

}
