package interviewQuestionsWithoutMainMethod;

import org.testng.annotations.Test;

public class SwapNumbers {
	@Test
	public static void swapNumbers() {
		int a = 5;
		int b = 7;

		int temp;

		temp = a;
		a = b;
		b = temp;

		System.out.println(a);
		System.out.println(b);

	}

	public static void swap(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println(a);
		System.out.println(b);

	}

}
