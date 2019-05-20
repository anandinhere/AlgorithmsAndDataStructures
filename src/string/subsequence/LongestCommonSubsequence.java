package string.subsequence;

import matrix.MatrixUtil;

public class LongestCommonSubsequence {

	static int recurseCountDP = 0;
	static int recurseCountNoDP = 0;

	public static void main(String[] args) {

		String str1 = "a b c d e f";
		String str2 = "abc  def";
		int l = getLengthOfLCS(str1, str2, 0,0);
		System.out.println(l);

		int[][] lcsDP = new int[str1.length() + 1][str2.length() + 1]; //Initialize DP matrix, size 1 more than actual

		MatrixUtil.init2DMatrixTopDown(lcsDP);

		int lenDP = getLengthOfLCSUsingDP(str1, str2, 0,0, lcsDP);
		System.out.println(lenDP);

		System.out.println("recurseCountDP " + recurseCountDP);
		System.out.println("recurseCountNoDP " + recurseCountNoDP);

	}


	// No DP
	private static int getLengthOfLCS(String str1, String str2, int m, int n) {
		recurseCountNoDP++;
		if (m == str1.length() || n == str2.length()) {
			return 0;
		}
		if (str1.charAt(m ) == str2.charAt(n)) {
			return getLengthOfLCS(str1, str2, m + 1, n + 1) + 1;
		} else {
			return Math.max(getLengthOfLCS(str1, str2, m + 1, n), getLengthOfLCS(str1, str2, m, n + 1));
		}

	}

	private static int getLengthOfLCSUsingDP(String str1, String str2, int m, int n, int[][] lcsDP) {

		recurseCountDP++;
		if (m == str1.length() || n == str2.length()) {
			return 0;
		}

		//if already memoized, use it
		if (lcsDP[m][n] != -1) {
			return lcsDP[m][n];
		}

		if (str1.charAt(m ) == str2.charAt(n )) {
			lcsDP[m][n] = getLengthOfLCSUsingDP(str1, str2, m + 1, n + 1, lcsDP) + 1;
		} else {
			lcsDP[m][n] = Math.max(getLengthOfLCSUsingDP(str1, str2, m + 1, n, lcsDP),
					getLengthOfLCSUsingDP(str1, str2, m, n + 1, lcsDP));
		}

		return lcsDP[m][n];
	}


	/*
	[
	[1,1,0],
	[0,1,1],
	[0,0,0],
	[1,1,1],
	[0,1,0]]
	 */
}
