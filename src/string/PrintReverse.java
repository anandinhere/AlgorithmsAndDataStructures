package string;

public class PrintReverse {
	public static void main(String[] args) {
		String str = "anand";

		printReverse(str.toCharArray(), str.length());
	}

	private static void printReverse(char[] charArray, int length) {
		if (length <= 0)
			return;
		System.out.println(charArray[length - 1]);
		printReverse(charArray, length - 1);

	}
}
