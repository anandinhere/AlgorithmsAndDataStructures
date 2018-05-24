package string.printall;

public class Permutations {
	public static int permCount = 0;

	public static void main(String[] args) {

		char[] inputArr = { 'a', 'b', 'c' };
		printPermutations(inputArr, 0);

	}

	private static void printPermutationsGeeks(char[] inputArr, int start) {
		permCount++;
		System.out.println(permCount);
		if (start == inputArr.length - 1) {
			for (int j = 0; j < inputArr.length; j++) {
				System.out.print(inputArr[j]);
			}
			System.out.println();
		} else {

			for (int i = start; i < inputArr.length; i++) {
				swap(inputArr, start, i);
				printPermutationsGeeks(inputArr, start + 1);
				swap(inputArr, start, i);

			}
		}

	}

	private static void printPermutations(char[] inputArr, int index) {
		permCount++;
		// System.out.println(permCount);

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
