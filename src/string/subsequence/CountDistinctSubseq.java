package string.subsequence;

import matrix.MatrixUtil;

public class CountDistinctSubseq {

	static String str = "gggg";
	static int[] lastIndexArr = new int[256];
	// Golden Rule - DP Matrix size always 1 greater than input
	static int[] dpMatrix = new int[str.length() + 1];

	// https://www.geeksforgeeks.org/count-distinct-subsequences/
	public static void main(String[] args) {

		MatrixUtil.init1DMatrixTopDown(dpMatrix);
		MatrixUtil.init1DMatrixTopDown(lastIndexArr);
		// lastIndex[str.charAt(0)] = 0;
		int count = 0;

		for (int i = 0; i <= str.length(); i++) {
			count = getCount(4);
			System.out.println(count);
		}

	}

	private static int getCount(int i) {
		if (dpMatrix[i] != -1) {
			return dpMatrix[i];
		}

		if (i == 0) {
			dpMatrix[i] = 1;
			return 1;
		}

		int count = 2 * getCount(i - 1);
		// Because we are starting with one index ahead
		int lastIndex = lastIndexArr[str.charAt(i - 1)];
		if (lastIndex != -1)
			count = count - getCount(lastIndex);

		// Because we are starting with one index ahead
		lastIndexArr[str.charAt(i - 1)] = i - 1;
		dpMatrix[i] = count;
		return count;
	}

}
