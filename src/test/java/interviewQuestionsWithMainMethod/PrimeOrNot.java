package interviewQuestionsWithMainMethod;

import java.util.Scanner;

public class PrimeOrNot {

	public static void main(String[] args) {
		System.out.println("Give me a number to check: ");
		//Scanner in = new Scanner(System.in);
		//int numberToCheck = in.nextInt();
		int numberToCheck = 7;
		int remainder;
		boolean isPrime = true;

		// Loop to check whether the numberToCheck is divisible by any other number
		// other than 1 and itself:
		for (int i = 2; i <= numberToCheck / 2; i++) {
			// numberToCheck is divided by itself
			remainder = numberToCheck % i;	
			// if remainder is 0 than numberToCheckber is not prime and break loop. Else
			// continue loop
			if (remainder == 0) {
				isPrime = false;
				break;
			}
		}
		 // Check value true or false,if isprime is true then numberToCheckber is prime otherwise not prime
		  if(isPrime) {
		     System.out.println(numberToCheck + " is a Prime number");
		  } else {
		     System.out.println(numberToCheck + " is not a Prime number");
		    }
		 
		  }

	}



/*
 * PrimeNumber: A prime number is a number that is only divisible by 1 or
 * itself. For example, 11 is only divisible by 1 or itself. Other Prime numbers
 * 2, 3, 5, 7, 11, 13, 17.... Note: 0 and 1 are not prime numbers. 2 is the only
 * even prime number. Logic: We need to divide an input number, say 17 from
 * values 2 to 17 and check the remainder. If remainder is 0 number is not
 * prime. No number is divisible by more than half of itself. So we need to loop
 * through just numberToCheck/2 . If input is 17, half is 8.5 and the loop will
 * iterate through values 2 to 8 If a numberToCheck is completely divisible by
 * other number, flag isPrime is set to true and the loop is exited.
 */