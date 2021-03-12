package interviewQuestionsWithMainMethod;

public class DuplicateString {

	public static void main(String[] args) {

		String userString = "w3 schools 3";
		String finalString = userString.replace(" ", "");
		System.out.println(finalString);		
		char[] userCharArray = finalString.toCharArray();
		int count = 0;
		
		System.out.println("Duplicate characters are : ");
		for(int i=0; i<finalString.length(); i++) {
			for(int j=i+1; j<finalString.length(); j++) {
				if(userCharArray[i]==userCharArray[j]) {
					System.out.println(userCharArray[j]);
					count++;
					break;
				}
				
			}
		}

	}

}
