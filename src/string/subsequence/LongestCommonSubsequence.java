package string.subsequence;

public class LongestCommonSubsequence {
	public static void main(String[] args) {

		String str1 = "abcd";
		String str2 = "abfgc34def";
		int l = getLengthOfLCS(str1, str2, str1.length(), str2.length());
		System.out.println(l);

		int[][] lcsDP = new int[str1.length()][str2.length()];
		int lenDP = getLengthOfLCSUsingDP(str1, str2, str1.length(), str2.length(), lcsDP);
		System.out.println(lenDP);
	}

	// No DP
	private static int getLengthOfLCS(String str1, String str2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}
		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return getLengthOfLCS(str1, str2, m - 1, n - 1) + 1;
		} else {
			return Math.max(getLengthOfLCS(str1, str2, m - 1, n), getLengthOfLCS(str1, str2, m, n - 1));
		}

	}

	private static int getLengthOfLCSUsingDP(String str1, String str2, int m, int n, int[][] lcsDP) {

		if (m == 0 || n == 0) {
			return 0;
		}
		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			lcsDP[m - 1][n - 1] = getLengthOfLCSUsingDP(str1, str2, m - 1, n - 1, lcsDP) + 1;
		} else {
			lcsDP[m - 1][n - 1] = Math.max(getLengthOfLCSUsingDP(str1, str2, m - 1, n, lcsDP),
					getLengthOfLCSUsingDP(str1, str2, m, n - 1, lcsDP));
		}

		return lcsDP[m - 1][n - 1];
	}

}
