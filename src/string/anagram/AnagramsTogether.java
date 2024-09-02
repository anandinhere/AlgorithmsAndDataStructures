package string.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import array.sorting.MergeSortString;

public class AnagramsTogether {
	public static void main(String[] args) {
		String[] inputStrings = { "cat", "dog", "tac", "god", "act", "ogd" };

		anagramsTogetherSet1(inputStrings);

	}
	
	//Complexity - O(NMLogM) n - no of string. m max length of string
	// hashMap of keys and list of input strings. hash the input to a key and append to value list.
	// Appending indexes here. May append actual inputs too?

	public static void anagramsTogetherSet1(String[] inputStrings) {
		String[] temp = new String[inputStrings.length];

		HashMap<String, LinkedList<Integer>> map = new HashMap<String, LinkedList<Integer>>();

		for (int i = 0; i < inputStrings.length; i++) {
			temp[i] = String.valueOf(MergeSortString.mergeSort(
					inputStrings[i].toCharArray(), 0,
					inputStrings[i].length() - 1));

			/*
			 * temp[i] = inputStrings[i];
			 * 
			 * char[] c = temp[i].toCharArray(); Arrays.sort(c); temp[i] =
			 * String.valueOf(c); // System.out.println(temp[i]);
			 */

			if (map.containsKey(temp[i])) {
				map.get(temp[i]).add(i);
			} else {
				LinkedList<Integer> l = new LinkedList<Integer>();
				l.add(i);
				map.put(temp[i], l);
			}

		}

		for (Entry<String, LinkedList<Integer>> e : map.entrySet()) {

			for (Integer i : e.getValue()) {
				System.out.println(inputStrings[i]);
			}
		}

	}

	public static void anagramsTogetherSet2(String[] inputStrings) { //Incomplete
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

		for (int i = 0; i < inputStrings.length; i++) {

			int hash = getHash(inputStrings[i]);
			if (map.containsKey(hash)) {

			} else {
				LinkedList<Integer> l = new LinkedList<Integer>();
				l.add(i);
				map.put(hash, l);
			}

		}

	}

	private static int getHash(String string) {
		int hash = 0;
		for (int i = 0; i < string.length(); i++) {
			hash = hash + (int) (string.charAt(i));
		}
		return hash;
	}
}
