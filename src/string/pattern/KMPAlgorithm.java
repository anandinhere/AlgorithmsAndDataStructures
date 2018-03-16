package string.pattern;


public class KMPAlgorithm {
	public static void main(String[] args) {
		String txt = "aaaabababaaaaabababa";
		String pat = "ababab";

		searchPattern(txt, pat);

		int[] lps = getLPSarray(pat);

		//System.out.println(Arrays.toString(lps));
	}

	/*
	 * Time Complexity - O(m+n) - length of text m - length of pattern
	 */
	private static void searchPattern(String txt, String pat) {

		int[] lps = getLPSarray(pat);

		int i = 0;
		int j = 0;

		while (i < txt.length()) {
			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}

			if (j == lps.length) {
				System.out.println("pattern match at " + (i - j));
				j = lps[j - 1];
			} else if (i < txt.length() && pat.charAt(j) != txt.charAt(i)) {
				if (j > 0) {
					j = lps[j - 1];
				} else
					i = i + 1;
			}
		}

	}

	private static int[] getLPSarray(String pat) {

		int length = pat.length();
		int[] lps = new int[length];

		int i = 0;
		int j = 0;
		lps[0] = 0;
		i++;

		// j will be equal to lps[i-1]. therefore if they are same, increment
		// i and j
		while (i < length) {

			if (pat.charAt(i) == pat.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			} else {
				if (j == 0) {
					lps[i] = 0;
					i++;
				} else { // if characters not matched, keep reducing j
					j = lps[j - 1];
				}
			}

		}

		return lps;
	}
}
