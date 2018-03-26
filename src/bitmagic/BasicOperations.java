package bitmagic;

public class BasicOperations {

	public static void main(String[] args) {

		System.out.println(~7);
		System.out.println(7&7);
		
		System.out.println(Integer.toBinaryString(127)+"\n"+Integer.toHexString(20));
		
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE)+" "+Integer.toBinaryString(Integer.MIN_VALUE));
		
		if ( (25 & 20) != 0 )
			System.out.println("bit 5 is on\n");
		
		System.out.println(7 & 8);
		
		//--------------
		

		//Absolute value of float
		System.out.println(Math.abs(-8));
		
		
		
		int x = Float.floatToIntBits(-12345.123f);
		System.out.println(x);
		String binary = Integer.toBinaryString( 
	             Float.floatToIntBits(-12345.123f) & 0x7FFFFFFF);
		
		//System.out.println(binary);
		
		int intBits = Integer.parseInt(binary, 2);
		float myFloat = Float.intBitsToFloat(intBits);
		System.out.println(myFloat);
		System.out.println("\n\n\n");
		
		
		// Inverse of float
		x = Float.floatToIntBits(2f);
		System.out.println(Integer.toBinaryString(x));
		
		System.out.println(Integer.toBinaryString((127<<24)-x));
		
		System.out.println(Float.intBitsToFloat((127<<24)-x));
		
		//- http://bits.stephan-brumme.com/inverse.html here shift is 23. shift by 24 seems to be right.

		System.out.println(~(~20+1)+1);
		
		
	}
}
