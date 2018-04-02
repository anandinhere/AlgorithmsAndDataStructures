package bitmagic;

public class SubtractNumbers {
	public static void main(String[] args) {
		add(20, 5);
	}

	public static void add(int x, int y) {
		BitUtil.print(x);
		BitUtil.print(y);

		int borrow = ~x & y;
		x = x ^ y;
		y = borrow << 1; // x holds the sum, y holds the carry, each iteration.
							// Just the while loop will also do.

		while (y != 0) {
			borrow = ~x & y;
			x = x ^ y;
			y = borrow << 1;
		}

		BitUtil.print(x);

	}
}
