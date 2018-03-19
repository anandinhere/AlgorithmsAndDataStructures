package string.palindrome;

public class LongestPalindromicSubstringBruteForce {
	public static void main(String[] args) {
		String str = "rofgeeksskeegfor";

		getLongestPalindrome(str);

	}

	private static void getLongestPalindrome(String str) {

		int maxLength = 0;
		int solnStart = -1;
		int solnEnd = -1;

		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				if (CheckPalindrome.checkPalindrome(str, i, j)) {
					System.out
							.println("Palindome : " + str.substring(i, j + 1));
					if (j - i + 1 > maxLength) {
						maxLength = j - i + 1;
						solnStart = i;
						solnEnd = j;
					}
					System.out.println(maxLength + " " + solnStart + " "
							+ solnEnd);
				}

			}
		}

	}
}
