package string.CharCountBased;

public class CountWords {
	public static void main(String[] args) {

		String sentence = "One two          three\n  four\nfive  ";

		char[] sentArr = sentence.toCharArray();

		int count = 0;
		boolean separator = true;

		for (int i = 0; i < sentArr.length; i++) {
			if (sentArr[i] == '\t' || sentArr[i] == '\n' || sentArr[i] == ' ') {
				separator = true;
			} else if (separator == true) {
				separator = false;
				count++;
			}

		}

		System.out.println(count);

	}
}
