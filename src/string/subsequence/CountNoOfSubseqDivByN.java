package string.subsequence;

//https://stackoverflow.com/questions/28454274/how-to-compute-the-remainder-of-a-very-large-number-string-with-1-mi-digits-in
//1) (a+b) mod c = (a mod c + b mod c) mod c
//2) 	(a*b) mod c = (a mod c * b mod c) mod c
//https://www.geeksforgeeks.org/number-subsequences-string-divisible-n/
public class CountNoOfSubseqDivByN {
	public static void main(String[] args) {
		 remainderTest2();
		int n = 4;

		String str = "1234";

		int count = getCount(str, str.length(), 0, n, "",0);
		System.out.println(count);

	}

	// All you need it NewDigit, remainder of old number, and n to find out new
	// remainder
	/*
	 * digCount - toKeep track of number of digits in subsequence. To comput newRem
	 * s - just for debug purpose
	 */
	private static int getCount(String str, int i, int r, int n, String s, int digCount) {

		System.out.println("r-" + r + " s-" + s);
		if (i == 0) {
			if (r == 0) {
				System.out.println(s);
			}
			return r == 0 ? 1 : 0;
		}

		int count = 0;
		int newChar = (str.charAt(i - 1) - '0');
		
		count += getCount(str, i - 1, r, n, s,digCount);
		
		//newRem to be computed only if the newChar is considered for subsequence.
		int newRem = 0;
		if (s.length() == 0) {
			newRem = newChar % n;
		} else {
			newRem = (int) ((r + ((newChar * Math.pow(10, digCount)) % n)) % n);
		}

		count += getCount(str, i - 1, newRem, n, newChar + s,digCount+1);

		return count;
	}

	private static void remainderTest() {

		// 1974
		int n = 4;
		int x = 197;
		int newChar = 4;

		int r = x % n;
		int newR = ((r * 10) + (newChar % n)) % n;

		System.out.println("r - " + r);
		System.out.println("newR - " + newR);

	}

	private static void remainderTest2() {

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
