package interviewQuestionsWithMainMethod;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		
		System.out.println("Give me a number");
		Scanner userInput = new Scanner(System.in); // make scanner for userinput
		
		int n = userInput.nextInt();

		for(int i = 1; i<=n; i++) {
			
			for(int j = 1; j<=n; j++) {  // make loop inside the loop
				
				System.out.print(i * j);
				System.out.print("  ");			
			}			
				
			System.out.println("\n");
		}
		userInput.close();
	}
}
