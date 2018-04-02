package bitmagic;

public class SwapBits {
	public static void main(String[] args) {
		int x = Integer.parseInt("00101111", 2);

		swapBits(x, 3, 4, 8);
	}

	public static void swapBits(int x, int n, int p1, int p2) {
		BitUtil.print(x);
		int mask = (1 << n) - 1; //make mask with all 1s
		BitUtil.print(mask);

		
		int mask1 = mask << (p1 - n); //move mask to p1 position
		BitUtil.print(mask1);
		int mask2 = mask << (p2 - n); //move mask to p2 position
		BitUtil.print(mask2);
		
		int p1sub = mask1&x; //p1 sequence only
		int p2sub = mask2&x; // p2 sequence only
		
		BitUtil.print(p1sub);
		BitUtil.print(p2sub);

		x = x & ~mask1; //make first sequence 0s
		BitUtil.print(x);
		x = x & ~mask2; //make second sequence 0s
		BitUtil.print(x);

		x = x ^ (p1sub<<(p2-p1)) ^ (p2sub>>(p2-p1)); //Interchange p1 and p2. XOR with x to set sub sequences.

		BitUtil.print(x);

	}
}
