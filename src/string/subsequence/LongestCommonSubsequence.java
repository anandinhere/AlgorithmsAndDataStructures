package string.subsequence;

public class LongestCommonSubsequence {

	static int recurseCountDP = 0;
	static int recurseCountNoDP = 0;

	public static void main(String[] args) {

		String str1 = "abcd";
		String str2 = "efghijklakjabaaabc";
		int l = getLengthOfLCS(str1, str2, str1.length(), str2.length());
		System.out.println(l);

		int[][] lcsDP = new int[str1.length() + 1][str2.length() + 1]; //Initialize DP matrix, size 1 more than actual

		initDPMatrix(str1, str2, lcsDP);

		int lenDP = getLengthOfLCSUsingDP(str1, str2, str1.length(), str2.length(), lcsDP);
		System.out.println(lenDP);

		System.out.println("recurseCountDP " + recurseCountDP);
		System.out.println("recurseCountNoDP " + recurseCountNoDP);

	}

	private static void initDPMatrix(String str1, String str2, int[][] lcsDP) {
		// Initializing DP matrix to -1
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0 || j == 0) {
					lcsDP[i][j] = 0;
				}
				lcsDP[i][j] = -1;
			}
		}
	}

	// No DP
	private static int getLengthOfLCS(String str1, String str2, int m, int n) {
		recurseCountNoDP++;
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

		recurseCountDP++;
		if (m == 0 || n == 0) {
			return 0;
		}

		//if already memoized, use it
		if (lcsDP[m][n] != -1) {
			return lcsDP[m][n];
		}

		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			lcsDP[m][n] = getLengthOfLCSUsingDP(str1, str2, m - 1, n - 1, lcsDP) + 1;
		} else {
			lcsDP[m][n] = Math.max(getLengthOfLCSUsingDP(str1, str2, m - 1, n, lcsDP),
					getLengthOfLCSUsingDP(str1, str2, m, n - 1, lcsDP));
		}

		return lcsDP[m][n];
	}

}
