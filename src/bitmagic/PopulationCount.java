package bitmagic;

public class PopulationCount {
	public static void main(String[] args) {
		
		//x&x-1 will zerofy lowest set 1
		
		int x = Integer.parseInt("11101101", 2);

		System.out.println("population count: " + Integer.bitCount(x));

		int count = 0;
		while (x != 0) {
			x &= x - 1;
			count++;
			System.out.println(Integer.toBinaryString(x));
		}
		System.out.println("population count: " + count);
	}
}
