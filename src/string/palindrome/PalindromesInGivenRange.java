package string.palindrome;

public class PalindromesInGivenRange {

	public static void main(String[] args) {

		generatePalindomes(1456, 0);

	}

	private static void generatePalindomes(int x, int fix) {

		if (x <= 10)
			return ;
		int powerOf10 = biggestPowerOf10(x);

		for (int i = 0; i < powerOf10; i++) {
			for (int num = 0; num < 10; num++) {
				System.out.println(num);
			}
		}


	}

	private static int biggestPowerOf10(int x) {

		int i = 10;
		while (i * 10 <= x) {
			i = i * 10;
		}

		return i;
	}
}
