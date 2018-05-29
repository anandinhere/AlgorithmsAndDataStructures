package string.subsequence;

//https://discuss.codechef.com/questions/92066/help-needed-for-solving-string-and-sub-sequences-problem?page=1#92116
//https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
public class CountSubseqOfFormAiBjCk {

	public static void main(String[] args) {

		String str =   "abbc";
		
		str = "abcabc";

		int[] abcCount = new int[str.length() + 1];
		int[] abCount = new int[str.length() + 1];
		int[] aCount = new int[str.length() + 1];

		// int count = getABCcountNoDP(str, abcCount, abCount, aCount, str.length());
		// System.out.println(count);

		initDPArrays(abcCount, abCount, aCount);

		int count = getABCcountDP(str, abcCount, abCount, aCount, str.length());
		System.out.println(count);

		count = getABCcountSimple(str);
		System.out.println(count);

	}

	/*
	 * private static int getABCcountNoDP(String str, int[] abcCount, int[] abCount,
	 * int[] aCount, int i) {
	 * 
	 * if (i == 0) { return 0; }
	 * 
	 * if (str.charAt(i - 1) == 'c') { return 2 * getABCcountNoDP(str, abcCount,
	 * abCount, aCount, i - 1) + getABcount(str, abcCount, abCount, aCount, i - 1);
	 * 
	 * } else return getABCcountNoDP(str, abcCount, abCount, aCount, i - 1); }
	 * 
	 * private static int getABcount(String str, int[] abcCount, int[] abCount,
	 * int[] aCount, int i) { if (i == 0) { return 0; } if (str.charAt(i - 1) ==
	 * 'b') { return 2 * getABcount(str, abcCount, abCount, aCount, i - 1) +
	 * getAcount(str, abcCount, abCount, aCount, i - 1); } else return
	 * getABcount(str, abcCount, abCount, aCount, i - 1);
	 * 
	 * }
	 * 
	 * private static int getAcount(String str, int[] abcCount, int[] abCount, int[]
	 * aCount, int i) { if (i == 0) { return 0; } if (str.charAt(i - 1) == 'a') {
	 * return 2 * getAcount(str, abcCount, abCount, aCount, i - 1) + 1; } else
	 * return getAcount(str, abcCount, abCount, aCount, i - 1);
	 * 
	 * }
	 */

	private static int getABCcountSimple(String str) {
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;

		for (char c : str.toCharArray()) {
			switch (c) {
			case 'a':
				aCount = 1 + 2 * aCount;
				break;
			case 'b':
				bCount = aCount + 2 * bCount;
				break;
			case 'c':
				cCount = bCount + 2 * cCount;
				break;

			default:
				break;
			}
		}
		return cCount;
	}

	private static void initDPArrays(int[] abcCount, int[] abCount, int[] aCount) {
		for (int i = 0; i < abcCount.length; i++) {
			abcCount[i] = -1;
			abCount[i] = -1;
			aCount[i] = -1;
		}

	}

	private static int getABCcountDP(String str, int[] abcCount, int[] abCount, int[] aCount, int i) {

		if (i == 0) {
			return 0;
		}

		if (abcCount[i] != -1) {
			return abcCount[i];
		}

		if (str.charAt(i - 1) == 'c') {
			abcCount[i] = 2 * getABCcountDP(str, abcCount, abCount, aCount, i - 1)
					+ getABcountDP(str, abcCount, abCount, aCount, i - 1);

		} else
			abcCount[i] = getABCcountDP(str, abcCount, abCount, aCount, i - 1);

		return abcCount[i];
	}

	private static int getABcountDP(String str, int[] abcCount, int[] abCount, int[] aCount, int i) {
		if (i == 0) {
			return 0;
		}

		if (abCount[i] != -1) {
			return abCount[i];
		}

		if (str.charAt(i - 1) == 'b') {
			abCount[i] = 2 * getABcountDP(str, abcCount, abCount, aCount, i - 1)
					+ getAcountDP(str, abcCount, abCount, aCount, i - 1);
		} else
			abCount[i] = getABcountDP(str, abcCount, abCount, aCount, i - 1);

		return abCount[i];
	}

	private static int getAcountDP(String str, int[] abcCount, int[] abCount, int[] aCount, int i) {
		if (i == 0) {
			return 0;
		}

		if (aCount[i] != -1) {
			return aCount[i];
		}
		if (str.charAt(i - 1) == 'a') {
			aCount[i] = 2 * getAcountDP(str, abcCount, abCount, aCount, i - 1) + 1;
		} else
			aCount[i] = getAcountDP(str, abcCount, abCount, aCount, i - 1);

		return aCount[i];
	}

}
