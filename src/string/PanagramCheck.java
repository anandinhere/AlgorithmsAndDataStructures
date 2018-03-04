package string;

public class PanagramCheck {
	public static void main(String[] args) {
		String str = "he quick brown fox jumps over the lay dog";

		boolean check = panagramCheck(str);

		// System.out.println('c' - 'a');
		System.out.println(check);
	}

	private static boolean panagramCheck(String str) {

		int[] ascii = new int[26];

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ')
				continue;
			int chari = (int) (c - 'a');
			ascii[chari]++;
		}

		for (int i = 0; i < ascii.length; i++) {
			if (ascii[i] == 0) {

				return false;
			}
		}

		return true;
	}
}
