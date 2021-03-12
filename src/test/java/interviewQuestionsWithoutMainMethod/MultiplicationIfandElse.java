package interviewQuestionsWithoutMainMethod;

public class MultiplicationIfandElse {

	
	public static void main (String[] args) {

		// Print 1 to N
		// If the number is multiple of 3 print "FIZZ" instead of the number
		// if the number is multiple of 5 print "BUZZ" instead of the number
		// if the number is multiple of 3 and 5 print "FIZZ BUZZ" instead of the number

		int N = 100;
		for (int i = 1; i <= N; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FIZZ BUZZ");
			} else if (i % 3 == 0) {
				System.out.println("FIZZ");
			} else if (i % 5 == 0) {
				System.out.println("BUZZ");
			} else {
				System.out.println(i);
			}
		}

	}

}
