package interviewQuestionsWithMainMethod;

import java.util.Arrays;

public class SortArrayWithArraysSort {

	public static void main(String[] args) {
		int[] myArray = { 5, 1, 8, 6, 2 };

		for (int x : myArray) {
			System.out.println(x);
		}

		Arrays.sort(myArray);

		for (int x : myArray) {
			System.out.println("SortedArray : " + x);
		}

	}

}
