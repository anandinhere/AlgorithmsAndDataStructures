package bitmagic;

public class NextHigherNumberWithSameNoOfSetBits {
	public static void main(String[] args) {

		int x = Integer.parseInt("1", 2);

		print(x);

		nextHigherNumberGeeks(x);

	}

	private static void nextHigherNumberGeeks(int x) {
		// rightmost 1 becomes 0
		int mask = x & ~(x - 1);

		// bit left to the contiguous 1s becomes 1
		x = x + mask;
		print(x);

		// counting number of contiguous 1s
		int contiguous1sCount = 0;
		while ((mask | x) != x) {
			mask = mask << 1;
			contiguous1sCount++;
		}

		// contiguous 1s (1 less than actual) moving to the right most
		int ones = 0;
		for (int i = 0; i < contiguous1sCount - 1; i++) {
			ones = ones | 1 << i;
		}

		x = x | ones;

		print(x);
	}

	private static void nextHigherNumber(int x) {
		// rightmost 1 becomes 0
		int mask = x & ~(x - 1);

		print(mask);

		int contiguous1sCount = 0;

		while ((mask | x) == x) {
			mask = mask << 1; // mask moves 1 position ahead of contiguous 1s
			contiguous1sCount++;
		}

		// all contiguous 1s become 0
		for (int i = 0; i < contiguous1sCount; i++) {
			x = x & x - 1;
		}

		// contiguous 1s (1 less than actual) moving to the right most
		int ones = 0;
		for (int i = 0; i < contiguous1sCount - 1; i++) {
			ones = ones | 1 << i;
		}

		x = x | mask;
		x = x | ones;

		print(x);
	}

	public static void print(int z) {
		System.out.println("Decimal " + z);
		System.out.println("Binary " + Integer.toBinaryString(z));
	}
}
