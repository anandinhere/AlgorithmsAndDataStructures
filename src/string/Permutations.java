package string;

public class Permutations {

	static char[] inputArr = { 'a', 'b', 'c' };

	public static void main(String[] args) {

		printPermutations(0, inputArr.length);

	}

	private static void printPermutations(int start, int length) {

		if (start == length - 1) {
			print();
		} else {

			for (int i = start; i < length; i++) {
				swap(start, i);
				printPermutations(start + 1, length);
				swap(start, i);

			}
		}

	}

	private static void print() {
		for (char c : inputArr) {
			System.out.print(c);
		}
		System.out.println();

	}

	private static void swap(int i, int start) {
		char temp = inputArr[start];
		inputArr[start] = inputArr[i];
		inputArr[i] = temp;

	}
}
