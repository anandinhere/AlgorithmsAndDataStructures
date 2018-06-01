package string.subsequence;

//https://stackoverflow.com/questions/28454274/how-to-compute-the-remainder-of-a-very-large-number-string-with-1-mi-digits-in
//1) (a+b) mod c = (a mod c + b mod c) mod c
//2) 	(a*b) mod c = (a mod c * b mod c) mod c
//https://www.geeksforgeeks.org/number-subsequences-string-divisible-n/
public class CountNoOfSubseqDivByN {

	static int[][][] countDP;
	static int[][] countDPEff;

	public static void main(String[] args) {
		remainderTestAddCharToRight();
		int n = 4;

		String str = "1234";

		int count;
//		count = getCountNoDP(str, str.length(), 0, n, "", 0);
//
//		// count reduced by 1 so as to not consider empty subsequence
//		System.out.println("Recursion Solution " + new Integer(count - 1));
//
//		countDP = new int[str.length() + 1][n][str.length()];

//
//		initDPMatrix(countDP);
//		initDPMatrixEff(countDPEff);
//
//		count = getCountDPTopDown(str, str.length(), 0, n, "", 0);
//
//		// count reduced by 1 so as to not consider empty subsequence
//		System.out.println("DP Solution " + new Integer(count - 1));
//		// System.out.println(countDP[str.length()][0][0]);

		countDPEff = new int[str.length()][n + 1];
		initDPMatrixEff(countDPEff);

		count = getCountDPEffTopDown(str, 0, 0, n, "");

		// count reduced by 1 so as to not consider empty subsequence
		System.out.println("DP TopDown EffSolution " + new Integer(count - 1));

	}

	private static void initDPMatrix(int[][][] countDP) {

		// System.out.println(countDP.length + " " + countDP[0].length + " " +
		// countDP[0][0].length);

		for (int i = 1; i < countDP.length; i++) {
			for (int j = 0; j < countDP[0].length; j++) {
				for (int k = 0; k < countDP[0][0].length; k++) {
					countDP[i][j][k] = -1;
				}
			}
		}

	}

	private static void initDPMatrixEff(int[][] countDP) {

		// System.out.println(countDP.length + " " + countDP[0].length + " " +
		// countDP[0][0].length);

		for (int i = 0; i < countDPEff.length; i++) {
			for (int j = 0; j < countDPEff[0].length; j++) {
				countDPEff[i][j] = -1;

			}
		}

	}

	// All you need is NewDigit, remainder of old number, and n to find out new
	// remainder
	/*
	 * digCount - toKeep track of number of digits in subsequence. To comput newRem
	 * s - just for debug purpose
	 * 
	 * digCount - keeping track of digCount is almost like keeping track of
	 * actualNumber.
	 * 
	 * If the number is traversed from start --> end digCount can be avoided as the
	 * formula for new remainder doesn't require keeping track of number of Digits.
	 * 
	 */
	private static int getCountNoDP(String str, int i, int r, int n, String s, int digCount) {

		System.out.println("r-" + r + " s-" + s + " i-" + i);
		if (i == 0) {
			if (r == 0) {
				System.out.println(s);
			}
			return r == 0 ? 1 : 0;
		}

		int count = 0;
		int newChar = (str.charAt(i - 1) - '0');

		count += getCountNoDP(str, i - 1, r, n, s, digCount);

		// newRem to be computed only if the newChar is considered for subsequence.
		int newRem = 0;
		if (digCount == 0) {
			newRem = newChar % n;
		} else {
			newRem = (int) ((r + ((newChar * Math.pow(10, digCount)) % n)) % n);
		}

		// count + 1 because , one more char is included for computing new remainder
		count += getCountNoDP(str, i - 1, newRem, n, newChar + s, digCount + 1);

		return count;
	}

	//O(n^3)
	private static int getCountDPTopDown(String str, int i, int r, int n, String s, int digCount) {

		System.out.println("r-" + r + " s-" + s + " i-" + i);
		if (i == 0) {
			if (r == 0) {
				System.out.println(s);
			}
			return r == 0 ? 1 : 0;
		}

		if (countDP[i][r][digCount] != -1) {
			return countDP[i][r][digCount];
		}
		int newChar = (str.charAt(i - 1) - '0');

		// basically computing r and newR
		// count is sum of subseq including and not including this char
		countDP[i][r][digCount] = getCountDPTopDown(str, i - 1, r, n, s, digCount);

		// newRem to be computed only if the newChar is considered for subsequence.
		int newRem = 0;
		if (digCount == 0) {
			newRem = newChar % n;
		} else {
			newRem = (int) ((r + ((newChar * Math.pow(10, digCount)) % n)) % n);
		}

		// count + 1 because , one more char is included for computing new remainder
		countDP[i][r][digCount] += getCountDPTopDown(str, i - 1, newRem, n, newChar + s, digCount + 1);

		return countDP[i][r][digCount];
	}

	//O(n^2)
	private static int getCountDPEffTopDown(String str, int i, int r, int n, String s) {
		//System.out.println("s "+s);
		
		
		
		System.out.println("r-" + r + " s-" + s + " i-" + i);
		if (i == str.length()) {
			if (r == 0) {
				System.out.println(s);
			}
			return r == 0 ? 1 : 0;
		}

		if (countDPEff[i][r] != -1) {
			return countDPEff[i][r];
		}
		int newChar = (str.charAt(i) - '0');

		// basically computing r and newR
		// count is sum of subseq including and not including this char
		countDPEff[i][r] = getCountDPEffTopDown(str, i + 1, r, n, s);

		// newRem to be computed only if the newChar is considered for subsequence.
		int newRem = 0;

		newRem = (int) (((r * 10) + (newChar % n)) % n);

		// count + 1 because , one more char is included for computing new remainder
		
		countDPEff[i][r] += getCountDPEffTopDown(str, i + 1, newRem, n, s + newChar);

		return countDPEff[i][r];
	}

	private static int getCountDPBottomUp(String str, int r, int n, String s) {

		// Filling value for first digit in str
		countDPEff[0][(str.charAt(0) - '0') % n]++;

		for (int i = 1; i < countDP.length; i++) {

			// start a new subsequence with index i
			countDPEff[i][(str.charAt(i) - '0') % n]++;
			for (int j = 0; j < countDP[0].length; j++) {
				// exclude i'th character from all the
				// current subsequences of string [0...i-1]
				countDPEff[i][j] += countDPEff[i - 1][j];

				// include i'th character in all the current
				// subsequences of string [0...i-1]
				countDPEff[i][(j * 10 + (str.charAt(i) - '0')) % n] += countDPEff[i - 1][j];

			}
		}

		return countDPEff[str.length()][0];
	}

	private static void remainderTestAddCharToRight() {

		// 1974
		int n = 4;
		int x = 0;
		int newChar = 5;

		int r = x % n;
		r = 0;
		int newR = ((r * 10) + (newChar % n)) % n;

		System.out.println("r - " + r);
		System.out.println("newR - " + newR);

	}

	private static void remainderTestAddCharToLeft() {

		// 13
		int n = 4;
		int x = 24;
		int newChar = 1;

		int r = x % n;
		int newR = (int) (((r) + ((newChar * Math.pow(10, 2)) % n)) % n);

		System.out.println("r - " + r);
		System.out.println("newR - " + newR);

	}

}
