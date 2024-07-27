import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Number_to_Words {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Prompt user how many tests they want to do
		System.out.print("How many tests do you want to do? >> ");
		int numOfIntegers = input.nextInt();
		input.nextLine();

		//Prompt user a number
		for (int i = 0; i < numOfIntegers; i++) {
			System.out.print("Enter a number >> ");
			long number = input.nextLong();
			printNumberInWords(number);
		}
		input.close();
	}

	public static void printNumberInWords(long num) {
		if (num == 0) {
			System.out.println("Zero");
			return;
		}

		String numberInString = "";
		int denominator = 1000;

		int i = 0;
		while (num > 0) {// 523,502,231
			long remainder = num % denominator;
			
			if(remainder != 0) {
				numberInString = getThreeDigits(remainder, i) + numberInString;
			}
			
			num /= 1000;
			i++;
		}

		System.out.println(numberInString);
	}

	public static String getThreeDigits(long number, int i) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");

		String[] arrayOfHundred = { "Hundred", "Thousand", "Million", "Billion", "Trillion" };

		long remainder = number;
		String numberInWords = "";

		// Get the first number out of 3
		if (number / 100 != 0) {
			numberInWords += map.get((int) number / 100);
			numberInWords += " " + arrayOfHundred[0] + " ";
		}

		// Get the second and third number out of 3
		remainder = number % 100;
		if (remainder / 10 == 0 && remainder != 0) {
			numberInWords += map.get((int) remainder % 10);
		} else if (remainder / 10 == 1) {
			numberInWords += map.get((int) remainder);
		} else if (remainder % 10 != 0) {
			numberInWords += map.get((int) remainder / 10 * 10) + " " + map.get((int) remainder % 10);
		} else if (remainder != 0) {
			numberInWords += map.get((int) remainder / 10 * 10);
		}

		if (i > 0 && remainder != 0) {
			numberInWords += " " + arrayOfHundred[i] + " ";
		}

		return numberInWords;
	}
}