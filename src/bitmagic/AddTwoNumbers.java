package bitmagic;

public class AddTwoNumbers {
	public static void main(String[] args) {
		add(633, 456);
	}

	public static void add(int x, int y) {
		BitUtil.print(x);
		BitUtil.print(y);

		int carry = x & y;
		x = x ^ y;
		y = carry << 1; //x holds the sum, y holds the carry, each iteration. Just the while loop will also do.

		while (y != 0) {
			carry = x & y;
			x = x ^ y;
			y = carry << 1;
		}

		BitUtil.print(x);

	}
}
