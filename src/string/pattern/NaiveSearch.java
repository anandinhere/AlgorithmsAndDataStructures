package string.pattern;

public class NaiveSearch {

	public static void main(String[] args) {
		String txt = "AABAACAADAABAABA";
		String ptrn = "AABA";

		searchPattern(txt, ptrn);
	}

	private static void searchPattern(String txt, String ptrn) {

		int curr = 0;
		int patLength = ptrn.length();

		while (curr + patLength <= txt.length()) {

		}

	}

}
