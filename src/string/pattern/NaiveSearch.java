package string.pattern;

public class NaiveSearch {

	public static void main(String[] args) {
		String txt = "AAAAA";
		String ptrn = "AAAA";

		searchPattern(txt, ptrn);
	}

	
	/*Time Complexity -  O(m*(n-m+1)) 
	 * n - length of text
	 * m - length of pattern
	 * */
	private static void searchPattern(String txt, String pat) {

		int patLength = pat.length();

		int curr = 0;
		while (curr + patLength <= txt.length()) {
			boolean flag = true;
			for (int i = curr, p = 0; i < curr + patLength; i++, p++) {

				if (txt.charAt(i) != pat.charAt(p)) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.println(curr);
			}
			curr++;
		}

	}

}
