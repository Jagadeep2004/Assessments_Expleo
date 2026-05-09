/*
 * find pin from given requirements
 */
package Programs;

import java.util.Scanner;

public class Problem_2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("input1 : ");
        int input1 = sc.nextInt();
        System.out.print("input2 : ");
        int input2 = sc.nextInt();
        System.out.print("input3 : ");
        int input3 = sc.nextInt();
        
        
        int a1 = input1 / 100;      
        int b1 = (input1 / 10)% 10; 
        int c1 = input1 % 10;       
        
        int a2 = input2 / 100;
        int b2 = (input2 / 10)% 10;
        int c2 = input2 % 10;
        
        int a3 = input3 / 100;
        int b3 = (input3 / 10)% 10;
        int c3 = input3 % 10;
        
        
        int leastHundreds = a1;
        int leastTens = b1;
        int leastUnits = c1;
        
        if (a2 < leastHundreds) {
        	leastHundreds = a2;
        }
        if (a3 < leastHundreds) {
        	leastHundreds = a3;
        }
                
        if (b2 < leastTens) {
        	leastTens = b2;
        }
        if (b3 < leastTens) {
        	leastTens = b3;
        }
        
        if (c2 < leastUnits) {
        	leastUnits = c2;
        }
        if (c3 < leastUnits) {
        	leastUnits = c3;
        }
        
        
        int maxDigit = a1; 
        
        
        int[] allDigits = {a1,b1,c1,a2,b2,c2,a3,b3,c3};
        
        for (int d : allDigits) {
            if (d > maxDigit) {
                maxDigit = d;
            }
        }
        
        
        int pin = maxDigit * 1000 + leastHundreds * 100 
                + leastTens * 10 + leastUnits;
        
        System.out.println("PIN = " + pin);
        
        sc.close();
    }
}