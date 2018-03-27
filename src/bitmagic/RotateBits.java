package bitmagic;

public class RotateBits {
	public static void main(String[] args) {
		int x = -21;

		System.out.println(Integer.toBinaryString(x));

		int bitSize = Integer.parseInt(System
				.getProperty("sun.arch.data.model"));

		System.out.println(bitSize);
		int rotation = 4;

		leftRotate(x, rotation, bitSize);

	}

	private static void leftRotate(int x, int rotation, int bitSize) {

		int result = x << rotation | x >>> (bitSize - rotation);
		System.out.println(Integer.toBinaryString(result));
	}
}
