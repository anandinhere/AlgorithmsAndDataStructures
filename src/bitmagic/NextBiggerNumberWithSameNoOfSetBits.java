package bitmagic;

public class NextBiggerNumberWithSameNoOfSetBits {
	public static void main(String[] args) {

		int x = Integer.parseInt("111", 2);

		print(x);
		// Step 1

		int mask = x & ~(x - 1);

		print(mask);

		int contiguous1sCount = 0;

		while ((mask | x) == x) {
			mask = mask << 1; //mask moves 1 position ahead of contiguous 1s
			contiguous1sCount++;
		}

		for (int i = 0; i < contiguous1sCount; i++) {
			x = x & x - 1;
		}

		int one = 0;
		for (int i = 0; i < contiguous1sCount - 1; i++) {
			one = one | 1 << i;
		}

		x = x | mask;
		x = x | one;

		print(x);

	}

	public static void print(int z) {
		System.out.println("Decimal " + z);
		System.out.println("Binary " + Integer.toBinaryString(z));
	}
}
