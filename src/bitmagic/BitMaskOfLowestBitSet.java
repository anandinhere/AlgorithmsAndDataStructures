package bitmagic;

public class BitMaskOfLowestBitSet {
	public static void main(String[] args) {
		int x = Integer.parseInt("11101100", 2);

		System.out.println(Integer.toBinaryString(~(x -1) & x));
	}
}
