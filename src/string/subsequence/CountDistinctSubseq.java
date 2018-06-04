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
			count = getCountRecursion(4);
			System.out.println(count);
		}

	}

	//This is not working becuase same lastIndexArr is being modified in recursive calls.
	// As it messes up already computed values for example in "gggg"
	// when doing third g, 2nd g value may get messed up and it propagates to 3rd g .
	// so better to save intermediate values. And since lastIndexMatrix is modified once per char,
	// we are safe.
	private static int getCountRecursion(int i) {

//		if (i == 0) {
//			dpMatrix[i] = 1;
//			return 1;
//		}

		int count = 2 * getCountRecursion(i - 1);
		// Because we are starting with one index ahead
		int lastIndex = lastIndexArr[str.charAt(i - 1)];
		if (lastIndex != -1)
			count = count - getCountRecursion(lastIndex);

		// Because we are starting with one index ahead
		lastIndexArr[str.charAt(i - 1)] = i - 1;
		dpMatrix[i] = count;
		return count;
	}

	private static int getCountDPTopDown(int i) {
		if (dpMatrix[i] != -1) {
			return dpMatrix[i];
		}

		if (i == 0) {
			dpMatrix[i] = 1;
			return 1;
		}

		int count = 2 * getCountDPTopDown(i - 1);
		// Because we are starting with one index ahead
		int lastIndex = lastIndexArr[str.charAt(i - 1)];
		if (lastIndex != -1) {
			count = count - getCountDPTopDown(lastIndex);
		}

		// Because we are starting with one index ahead

		lastIndexArr[str.charAt(i - 1)] = i - 1;
		dpMatrix[i] = count;
		return count;
	}

}
