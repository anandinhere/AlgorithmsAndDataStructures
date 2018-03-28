package bitmagic;

public class CountsBitsSet {
	public static void main(String[] args) {

		int x = Integer.parseInt("110011111000101010", 2);
		// count bits of each 2-bit chunk

		x = x - ((x >> 1) & 0x55555555);
		System.out.println(Integer.toBinaryString(x));
		// count bits of each 4-bit chunk
		x = (x & 0x33333333) + ((x >> 2) & 0x33333333);
		System.out.println(Integer.toBinaryString(x));
		// count bits of each 8-bit chunk
		x = x + (x >> 4);
		System.out.println(Integer.toBinaryString(x));
		// mask out junk
		x &= 0xF0F0F0F;
		System.out.println(Integer.toBinaryString(x));
		// add all four 8-bit chunks
		System.out.println((x * 0x01010101) >> 24);

	}

	public static int countBits(int x) {
		int count = 0;

		while (x > 0) {
			x = x & x - 1;
			count++;
		}

		return count;
	}
}
