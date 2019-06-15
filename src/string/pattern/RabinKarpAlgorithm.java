package string.pattern;

public class RabinKarpAlgorithm {
	public static void main(String[] args) {
		String txt = "abababbabaaaaabababa";
		String pat = "ababab";

		searchPattern(txt, pat);

		// System.out.println(Arrays.toString(lps));
	}

	/*
	 * Time Complexity O(n)
	 *  n - length of text,  m - length of pattern
	 */
	private static void searchPattern(String txt, String pat) {
		int hash = getHash(txt, 0, pat.length() - 1);
		int patternHash = getHash(pat, 0, pat.length() - 1);

		int patternLength = pat.length();
		int j = patternLength;

		while (j < txt.length()) {
			if (hash == patternHash) {
				if (txt.substring(j - patternLength, j).equals(pat)) {
					System.out.println("Found pattern match at index "
							+ (j - patternLength));
				}
			}
			hash = getRollingHash(txt, hash, j, patternLength);
			j++;
		}
	}

	private static int getRollingHash(String txt, int prevHash, int curr,
			int patternLength) {

		return prevHash - txt.charAt(curr - patternLength) + txt.charAt(curr);
	}

	private static int getHash(String txt, int start, int end) {

		int hash = 0;

		for (int i = start; i <= end; i++) {
			hash = hash + txt.charAt(i);
		}

		return hash;
	}
}
