package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import array.sorting.MergeSortString;

public class AnagramsTogether {
	public static void main(String[] args) {
		String[] inputStrings = { "cat", "dog", "tac", "god", "act" };

		anagramsTogetherSet1(inputStrings);

	}

	private static void anagramsTogetherSet1(String[] inputStrings) {
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
}
