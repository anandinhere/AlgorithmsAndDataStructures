package bitmagic;

public class BitMaskLowestBitNotSet {

	public static void main(String[] args) {
		int x = Integer.parseInt("11101101", 2);

		System.out.println(Integer.toBinaryString((x + 1) & ~x));
	}

}
