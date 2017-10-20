package string;

public class LexicographicRank {

	public static void main(String[] args) {
		rank("string");
	}

	private static void rank(String ip) {

		int factL = ip.length() - 1;
		int total = 0;
		for (int i = 0; i < ip.length(); i++) {

			int small = getSmall(ip.substring(i));
			total = total + small * factorial(factL);
			factL--;
			System.out.println(total);
		}
		System.out.println(total + 1);
	}

	private static int factorial(int factL) {

		if (factL == 0)
			return 0;
		if (factL == 1)
			return 1;
		return factL * factorial(factL - 1);
	}

	private static int getSmall(String substring) {

		char first = substring.charAt(0);
		int count = 0;
		for (int i = 1; i < substring.length(); i++) {

			if (first > substring.charAt(i)) {
				count++;
			}

		}
		return count;

	}
}
