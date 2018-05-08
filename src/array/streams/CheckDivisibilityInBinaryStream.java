package array.streams;

public class CheckDivisibilityInBinaryStream {
	public static void main(String[] args) {
		int[] binaryStream = new int[] { 1, 0, 0, 1, 1, 0, 0, 1, 0 };
		int k = 3;

		checkDivisibility(binaryStream, k);
		System.out.println();
		checkDivisibilityRemainderBased(binaryStream, k);
	}

	private static void checkDivisibilityRemainderBased(int[] binaryStream, int k) {
		int remainder = 0;
		for (int bin : binaryStream) {

			if (bin == 0) {
				remainder = (remainder * 2) % k;
			} else if (bin == 1) {
				remainder = (remainder * 2 + 1) % k;
			}

			if (remainder % k == 0) {
				System.out.println(remainder + " " + true);
			} else
				System.out.println(remainder + " " + false);
		}

	}

	private static void checkDivisibility(int[] binaryStream, int k) {
		int num = 0;
		for (int bin : binaryStream) {

			if (bin == 0) {
				num = num * 2;
			} else if (bin == 1) {
				num = num * 2 + 1;
			}

			if (num % k == 0) {
				System.out.println(num + " " + true);
			} else
				System.out.println(num + " " + false);
		}

	}
}
