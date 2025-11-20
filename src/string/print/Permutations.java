package string.print;

import java.util.Arrays;

public class Permutations {
	public static int permCount = 0;
	
	public static int [] reccount = new int[4];

	public static void main(String[] args) {

		//total number of recursive calls = 4 + 4*3 + 4*3*2
		
		char[] inputArr = { 'a', 'b', 'c'};
		printPermutationsGeeks(inputArr, 0);
		System.out.println(Arrays.toString(reccount));
		

	}

	private static void printPermutationsGeeks(char[] inputArr, int start) {
		
		if (start == inputArr.length - 1) {
			//no more recursions when start = len-1
			for (int j = 0; j < inputArr.length; j++) {
				System.out.print(inputArr[j]);
			}
			System.out.println();
		} else {

			for (int i = start; i < inputArr.length; i++) {
				reccount[start]++;
				swap(inputArr, start, i);
				
				printPermutationsGeeks(inputArr, start + 1);
				
				permCount++;
				System.out.println(permCount);
				
				swap(inputArr, start, i);

			}
		}
		

	}

	private static void printPermutations(char[] inputArr, int index) {
		permCount++;
		System.out.println(permCount);

		for (int i = index; i < inputArr.length; i++) {
			
			if (index == inputArr.length - 1) {
				for (int j = 0; j < inputArr.length; j++) {
					System.out.print(inputArr[j]);
				}
				System.out.println();
				// return;
			}

			swap(inputArr, index, i);
			printPermutations(inputArr, index + 1);
			swap(inputArr, index, i);

		}
	}

	private static void swap(char[] inputArr, int index, int i) {

		char temp = inputArr[index];
		inputArr[index] = inputArr[i];
		inputArr[i] = temp;

	}

}
