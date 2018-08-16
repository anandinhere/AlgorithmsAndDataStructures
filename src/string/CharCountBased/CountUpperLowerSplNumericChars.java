package string.CharCountBased;

public class CountUpperLowerSplNumericChars {
	public static void main(String[] args) {
		getCount("*GeEkS4GeEkS*");
	}

	private static void getCount(String s) {
		int upper = 0;
		int lower = 0;
		int spl = 0;
		int num = 0;

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (c >= 'a' && c <= 'z') {
				lower++;
			} else if (c >= 'A' && c <= 'Z') {
				upper++;
			} else if (c >= '0' && c <= '9') {
				num++;
			} else
				spl++;

		}

		System.out.println("upper " + upper);
		System.out.println("lower " + lower);
		System.out.println("num " + num);
		System.out.println("spl " + spl);
	}
}
