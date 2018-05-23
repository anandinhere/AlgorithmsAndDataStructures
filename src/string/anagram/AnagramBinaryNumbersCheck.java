package string.anagram;

public class AnagramBinaryNumbersCheck {

	public static void main(String[] args) {

		int num1 = 4;
		int num2 = 9;

		System.out.println(checkIfAnagrams(num1, num2));

	}

	private static boolean checkIfAnagrams(int num1, int num2) {

		int num1Count = get1Count(num1);
		int num2Count = get1Count(num2);

		return num1Count == num2Count;
	}

	private static int get1Count(int num) {

		int mask = 1;
		int count = 0;

		while (num != 0) {

			if ((num ^ mask) < num) {
				count++;
				num = num ^ mask;
			}

			mask = mask << 1;
		}
		return count;
	}
}
