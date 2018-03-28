package bitmagic;

public class RoundToNextPowerOf2 {
	public static void main(String[] args) {

		int x = Integer.parseInt("1000", 2);
		BitUtil.print(x);
		//x--;
		
		BitUtil.print(x);
		x = x | x >> 1;
		BitUtil.print(x);
		
		x = x | x >> 2;
		BitUtil.print(x);
		
		x = x | x >> 4;
		BitUtil.print(x);
		
		x = x | x >> 8;
		BitUtil.print(x);
		
		x++;
		
		BitUtil.print(x);

	}
}
