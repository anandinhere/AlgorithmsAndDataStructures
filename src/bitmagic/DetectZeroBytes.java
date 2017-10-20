package bitmagic;

public class DetectZeroBytes {
	public static void main(String[] args) {

		int x = Integer.parseInt("0100001000000010000000100000001", 2);
		
		x = Integer.parseInt("0", 2);
		
		
		System.out.println(0xFF );
		
		System.out.println("****");
		System.out.println(x);
		System.out.println(Integer.toBinaryString(0x01010101));
		System.out.println(Integer.toBinaryString(0x80808080));
		System.out.println("****");
		
		System.out.println(Integer.toBinaryString(x - 0x01010101));
		System.out.println(Integer.toBinaryString(~x));
		System.out.println(Integer.toBinaryString(0x80808080));
		
		System.out.println(((x - 0x01010101) & ~x & 0x80808080) != 0);
		
	}
}
