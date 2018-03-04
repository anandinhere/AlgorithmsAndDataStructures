package string;

import java.util.LinkedHashSet;

public class RemoveDups {
	public static void main(String[] args) {
		String str = "anand";

		removeDups(str);
	}	
	
	/*
	 *  Time-O(n) Space-O(n)
	 *  O(nlogn) is using sorting. Space Constant
	 */

	private static void removeDups(String str) {
		LinkedHashSet<Character> s = new LinkedHashSet<Character>();

		for (int i = 0; i < str.length(); i++) {
			s.add(str.charAt(i));
		}

		for (Character c : s) {
			System.out.println(c);
		}
	}
}
