package string.CharCountBased;

import java.util.HashMap;
import java.util.Random;

public class SmallestWindowAllCharsFromAnotherString {

	static final int no_of_chars = 256;

	// Another One -
	// https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
	// Function to find smallest window containing
	// all characters of 'pat'
	static String findSubStringGeeks(String str, String pat) {
		int len1 = str.length();
		int len2 = pat.length();

		// check if string's length is less than pattern's
		// length. If yes then no such window can exist
		if (len1 < len2) {
			System.out.println("No such window exists");
			return "";
		}

		int hash_pat[] = new int[no_of_chars];
		int hash_str[] = new int[no_of_chars];

		// store occurrence of characters of pattern
		for (int i = 0; i < len2; i++)
			hash_pat[pat.charAt(i)]++;

		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

		// start traversing the string
		int count = 0; // count of characters
		for (int j = 0; j < len1; j++) {
			// count occurrence of characters of string
			hash_str[str.charAt(j)]++;

			// If string's char matches with pattern's char
			// then increment count
			if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)]) {
				count++;
				System.out.println("count");
			}

			// if all the characters are matched
			if (count == len2) {
				// Try to minimize the window i.e., check if
				// any character is occurring more no. of times
				// than its occurrence in pattern, if yes
				// then remove it from starting and also remove
				// the useless characters.

				// Remember this while doesn't get executed first time when the substring with
				// the pattern chars if found.
				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {

					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}

				// update window size
				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		// If no window found
		if (start_index == -1) {
			System.out.println("No such window exists");
			return "";
		}

		// Return substring starting from start_index
		// and length min_len
		return str.substring(start_index, start_index + min_len);
	}

	static String findSubString(String str, String pat) {

		int[] patMap = new int[no_of_chars];
		for (int p = 0; p < pat.length(); p++) {
			char c = pat.charAt(p);
			patMap[c]++;
		}

		int[] strMap = new int[no_of_chars];

		int start = 0;
		int minLength = Integer.MAX_VALUE;
		int startIndex = -1;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);
			strMap[c]++;
			
			// '<' -- for incrementing.
			if (patMap[c] > 0 && strMap[c] <= patMap[c]) {
				
				count++;
			}

			if (count == pat.length()) {

				int chatAtStart = str.charAt(start);
				while (patMap[chatAtStart] == 0 || (strMap[chatAtStart] > patMap[chatAtStart])) {
					if (strMap[chatAtStart] > patMap[chatAtStart]) {
						strMap[chatAtStart]--;
						// count--;
					}
					start++;
					//since incrementing start, change start char
					chatAtStart = str.charAt(start);
				}

				int currLength = i - start + 1;

				if (currLength < minLength) {
					minLength = currLength;
					startIndex = start;
				}

			}

		}

		System.out.println(minLength);

		return str.substring(startIndex, startIndex + minLength);

	}

	// Driver Method
	public static void main(String[] args) {
		String str = "this is a test string";
		String pat = "tist";

		System.out.print("Smallest window is :  " + findSubString(str, pat));
	}
}
