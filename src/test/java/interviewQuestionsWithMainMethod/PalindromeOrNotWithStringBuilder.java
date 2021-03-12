package interviewQuestionsWithMainMethod;

import java.util.Scanner;

public class PalindromeOrNotWithStringBuilder {

	public static void main(String[] args) {

		System.out.println("Give me a string to reverse:");

		Scanner in = new Scanner(System.in);
		String userGivenString = in.nextLine();

		StringBuilder myObj = new StringBuilder(userGivenString);
		String reversedString = myObj.reverse().toString();

		if (userGivenString.equalsIgnoreCase(reversedString)) {
			System.out.println("Given string is : Palindrome");
		} else {
			System.out.println("Given string is : not a Palindrome!");
		}
		in.close();
	}

}
