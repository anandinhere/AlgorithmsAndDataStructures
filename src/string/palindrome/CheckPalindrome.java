package string.palindrome;

public class CheckPalindrome {

	public static void main(String[] args) {

		String inputStr = "ab";

		System.out.println(checkPalindrome(inputStr, 0, inputStr.length() - 1));
	}

	public static boolean checkPalindrome(String inputStr, int start, int end) {

		while (start < end) {
			if (inputStr.charAt(start) != inputStr.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}

}
