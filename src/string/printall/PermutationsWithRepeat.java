package string.printall;

import java.util.Arrays;

class PermutationsWithRepeat {

	static char[] input = { 'a', 'b', 'c' };
	static char[] output = { 'a', 'b', 'c' };

	public static void main(String[] args) {
		// code
		String str = "ABC";
		// char[] input = str.toCharArray();
		// char[] output = input.clone();
		printPermuteGeeks(0);

	}

	private static void printPermute(int start) {

		if (start == input.length) {
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = 0; i < input.length; i++) {

			output[start] = input[i];
			printPermute(start + 1);
			output[start] = input[start]; // this has no affect in this case
											// unlike in normal permutation

		}

	}

	private static void printPermuteGeeks(int index) {

		if (index == input.length) {
			System.out.println(output);
			return;
		}

		for (int i = 0; i < input.length; i++) {
			output[index] = input[i];
			printPermuteGeeks(index + 1);
		}

	}
}
