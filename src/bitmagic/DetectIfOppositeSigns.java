package bitmagic;

public class DetectIfOppositeSigns {
	public static void main(String[] args) {
		int x = 1;
		int y = 1;

		
		System.out.println((x^y)>>BitUtil.getBitSize()-1);
	}
}
