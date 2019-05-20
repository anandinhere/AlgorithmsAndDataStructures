package string.subsequence;

import matrix.MatrixUtil;

public class CountStr2SubseqInStr1 {
	static String strM = "anand";
	static String strN = "an";
	//DP Matrix Dimension always 1 greater than inputs
	static int[][] matrixDP = new int[strM.length() + 1][strN.length() + 1];

	public static void main(String[] args) {

		int count = getCountRecursion(0, 0);
		System.out.println("Recursion :" + count);

		MatrixUtil.init2DMatrixTopDown(matrixDP);
		count = getCountDPTopDown(strM.length(), strN.length());
		System.out.println("DP TopDown :" + count);

		MatrixUtil.init2DMatrixBottomUp(matrixDP);
		count = getCountDPBottomUp();
		System.out.println("DP BottomUp :" + count);

	}

	private static int getCountRecursion(int m, int n) {

		if (n == strN.length())
			return 1;
		if (m == strM.length() && n != strN.length())
			return 0;

		int count = 0;
		if (strM.charAt(m ) == strN.charAt(n )) {
			count = getCountRecursion(m + 1 , n + 1 ) + getCountRecursion(m + 1, n);
		} else
			count = getCountRecursion(m + 1 , n );
		return count;
	}

	private static int getCountDPTopDown(int m, int n) {

		if (n == 0)
			return 1;
		if (m == 0 && n != 0)
			return 0;

		if (matrixDP[m - 1][n - 1] != -1) {
			return matrixDP[m - 1][n - 1];
		}

		int count = 0;
		if (strM.charAt(m - 1) == strN.charAt(n - 1)) {
			count = getCountRecursion(m - 1, n - 1) + getCountRecursion(m - 1, n);
		} else
			count = getCountRecursion(m - 1, n);
		return count;
	}

	private static int getCountDPBottomUp() {

		// Set default case
		for (int i = 0; i < strM.length(); i++) {
			matrixDP[i][0] = 1;
		}

		for (int i = 1; i <= strM.length(); i++) {
			for (int j = 1; j <= strN.length(); j++) {
				if (strM.charAt(i - 1) == strN.charAt(j - 1)) {
					matrixDP[i][j] = matrixDP[i - 1][j - 1] + matrixDP[i - 1][j];
				} else
					matrixDP[i][j] = matrixDP[i - 1][j];
			}
		}

		return matrixDP[strM.length()][strN.length()];
	}
}
