package Assessment03;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter word : ");
		String word = sc.nextLine();
		
		if(word.length()>=2) {
			System.out.println("Word with first two letters : "+word.substring(0,2));
		}
		else if(word.length()==1){
			word=word.concat("@");
			System.out.println("Word with first two letters : "+word);
		}
		else {
			word=word.concat("@@");
			System.out.println("Word with first two letters : "+word);
		}
		
		sc.close();

	}

}
