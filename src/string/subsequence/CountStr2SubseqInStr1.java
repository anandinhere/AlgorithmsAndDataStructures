package string.subsequence;

import matrix.MatrixUtil;

public class CountStr2SubseqInStr1 {
	static String strM = "GeeksForGeeks";
	static String strN = "Gks";
	static int[][] matrixDP = new int[strM.length() + 1][strN.length() + 1];

	public static void main(String[] args) {

		int count = getCountRecursion(strM.length(), strN.length());
		System.out.println("Recursion :" + count);

		MatrixUtil.init2DMatrixTopDown(matrixDP);
		count = getCountDP(strM.length(), strN.length());
		System.out.println("DP TopDown :" + count);

	}

	private static int getCountRecursion(int m, int n) {

		if (n == 0)
			return 1;
		if (m == 0 && n != 0)
			return 0;

		int count = 0;
		if (strM.charAt(m - 1) == strN.charAt(n - 1)) {
			count = getCountRecursion(m - 1, n - 1) + getCountRecursion(m - 1, n);
		} else
			count = getCountRecursion(m - 1, n);
		return count;
	}

	private static int getCountDP(int m, int n) {

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
}
