package bitmagic;

public class TwoNonRepeatingNumber {
	public static void main(String[] args) {
		int a = Integer.parseInt("1001000", 2);

		int b = Integer.parseInt("1101000", 2);

		int x = Integer.parseInt("01000", 2);
		int y = Integer.parseInt("10000", 2);

		int[] arr = //{ 2, 3, 7, 9, 11, 2, 3, 11 };
		 { a, a, b, b, x,y };

		int sol1 = 0;
		int sol2 = 0;

		int xor = 0;

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);
			xor = xor ^ arr[i];
		}

		/* Get the rightmost set bit in set_bit_no */
		int set_bit_no = xor & ~(xor - 1);
		System.out.println("set_bit_no  " + Integer.toBinaryString(set_bit_no));

		/*
		 * Now divide elements in two sets by comparing rightmost set bit of xor
		 * with bit at same position in each element.
		 */
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & set_bit_no) > 0)
				sol1 = sol1 ^ arr[i]; /* XOR of first set */
			else
				sol2 = sol2 ^ arr[i]; /* XOR of second set */
		}

		System.out.println(Integer.toBinaryString(sol1) + "  " + sol1);
		System.out.println(Integer.toBinaryString(sol2) + "  " + sol2);

	}
}
