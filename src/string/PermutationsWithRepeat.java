package string;

class PermutationsWithRepeat {

	static char[] input = { 'a', 'b', 'c' };
	static char[] output = { 'a', 'b', 'c' };

	public static void main(String[] args) {
		// code
		String str = "ABC";
		// char[] input = str.toCharArray();
		// char[] output = input.clone();
		printPermute(0);

	}

	private static void printPermute(int index) {

		if (index == input.length) {
			System.out.println(output);
			return;
		}

		for (int i = 0; i < input.length; i++) {
			output[index] = input[i];
			printPermute(index + 1);
		}

	}
}
