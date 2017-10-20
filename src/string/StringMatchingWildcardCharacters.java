package string;

public class StringMatchingWildcardCharacters {

	static char[] str1 = new String("ge?ks*j").toCharArray();
	static char[] str2 = new String("geekshjjk").toCharArray();

	public static void main(String[] args) {

		System.out.println(match(0, 0));

		/*
		 * int i = 0; int j = 0;
		 * 
		 * boolean match = true;
		 * 
		 * while (i < str1.length && j < str2.length) {
		 * 
		 * if (i >= str1.length - 1 && j >= str2.length - 1) { match = true;
		 * break; }
		 * 
		 * if (str1[i] == str2[j] || str1[i] == '?') { i++; j++; }
		 * 
		 * if (str1[i] == '*' && i + 1 == str1.length) { match = true; break; }
		 * else if (str1[i] == '*' && i + 1 != str1.length && str2[j + 1] !=
		 * str2.length) {
		 * 
		 * while (j != str2.length && str2[j] != str1[i + 1]) { j++; } i++;
		 * 
		 * } }
		 * 
		 * System.out.println(match);
		 */

	}

	// http://www.geeksforgeeks.org/wildcard-character-matching/

	private static boolean match(int i, int j) {

		if (i == str1.length && j == str2.length) {
			return true;
		}

		if (str1[i] == '*' && i + 1 != str1.length && j == str2.length) {
			return true;
		}
		if (str1[i] == str2[j] || str1[i] == '?') {
			return true;
		}

		if (str1[i] == '*') {
			return match(i + 1, j) || match(i, j + 1);
		}

		return false;

	}
}
