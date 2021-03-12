package interviewQuestionsWithMainMethod;

import java.util.Scanner;

public class ReverseGivenString {
	
	public static void main(String[] args) {
	
		System.out.println("Give me a String!");
		Scanner in = new Scanner(System.in);
		String userGivenString = in.nextLine();
		char[] userCharArray = userGivenString.toCharArray();
		String reversedString = "";
		
		for(int i=userGivenString.length() -1; i>=0; i--) {
			reversedString = reversedString + userCharArray[i];					
		}
		System.out.println("ReversedString: " + reversedString);
		
		in.close();
	}

}

