package interviewQuestionsWithMainMethod;

public class DuplicateIntegerValue {

	public static void main(String[] args) {

		int[] intArray = { 1, 2, 3, 4, 2, 7, 8, 8 };
		//int length= intArray.length;
		//System.out.println(length);

		for (int i = 0; i < intArray.length; i++) {
			for (int j = i + 1; j < intArray.length; j++) {
				if (intArray[i] == intArray[j]) {
					System.out.println(intArray[j]);
				}
			}
		}

	}

}
