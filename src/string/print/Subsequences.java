package string.print;

public class Subsequences {
	public static void main(String[] args) {

		String s = "abc";

		printSubseq(s, s.length(), 0, "" + "");

	}

	private static void printSubseq(String s, int len, int i, String c) {
		if (len == 0) {
			System.out.println("");
			return;
		}

		if (len == 1) {
			System.out.println(c + s.charAt(i));
			System.out.println(c);
			return;
		}
		
		//current char either gets added or not
		
		printSubseq(s, len - 1, i + 1, c + s.charAt(i)); //inner subsequences with c

		printSubseq(s, len - 1, i + 1, c); //inner subsequences without c
	}
}
