package string.palindrome;

public class CheckPalindrome {

	public static void main(String[] args) {

		String inputStr = "ab";

		System.out.println(checkPalindrome(inputStr));
	}

	public static boolean checkPalindrome(String inputStr) {

		int start = 0;
		int end = inputStr.length() - 1;

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
