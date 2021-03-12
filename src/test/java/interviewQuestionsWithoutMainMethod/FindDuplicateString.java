package interviewQuestionsWithoutMainMethod;

import org.testng.annotations.Test;

public class FindDuplicateString {

	@Test
	public void findDuplicateString() {

		String givenString = "w3 schools 3";
		String finalString = givenString.replace(" ", ""); // Getting rid of the spaces in between words with this
															// function.
		System.out.println(finalString);

		int count = 0;

		char[] finalStringToCharArray = finalString.toCharArray();
		System.out.println("Duplicate characters are:  ");
		for (int i = 0; i < finalString.length(); i++) {
			for (int j = i + 1; j < finalString.length(); j++) {
				if (finalStringToCharArray[i] == finalStringToCharArray[j]) {
					System.out.println(finalStringToCharArray[j]);
					count++;
					break;
				}
			}
		}

	}

}
