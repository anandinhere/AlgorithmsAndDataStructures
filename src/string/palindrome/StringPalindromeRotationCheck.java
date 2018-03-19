package string.palindrome;

public class StringPalindromeRotationCheck {
	public static void main(String[] args) {
		String input = "aaaad";

		System.out.println(checkStringPalindromeRotation(input));
	}

	private static boolean checkStringPalindromeRotation(String inputStr) {

		int rotationsPossible = inputStr.length() / 2;

		int start = 0;
		int end = inputStr.length() - 1;
		
		//Alternatively can also make substrings of input string to form a rotation.
		for (int i = 0; i <= rotationsPossible; i++) {
			System.out.println(" ceck new ");
			if (checkPalindrome(inputStr, start, end))
				return true;
			start++;
			if (end == inputStr.length() - 1) {
				end = 0;
			} else
				end++;
		}

		return false;
	}

	public static boolean checkPalindrome(String inputStr, int start, int end) {

		for (int i = 0; i < inputStr.length() / 2; i++) {
			System.out.println(" ceck ");
			if (inputStr.charAt(start) != inputStr.charAt(end)) {
				return false;
			}
			start++;

			if (end == 0) {
				end = inputStr.length() - 1;
			} else
				end--;
		}

		return true;
	}
}
