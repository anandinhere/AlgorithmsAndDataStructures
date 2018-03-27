package bitmagic;

public class MinimumOrMaximumOfTwoIntegers {
	public static void main(String[] args) {
		getMin(4, 5);

	}

	private static void getMin(int x, int y) {

		System.out.println(y + ((x - y) & ((x - y) >> 63)));

	}

}
