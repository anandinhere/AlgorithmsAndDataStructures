package util;

import java.util.HashMap;
import java.util.Random;
import java.lang.Math;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.stream.Stream;

public class UsualImports {

	public static void main(String[] args) {
		Random r = new Random();

		HashMap<Integer, String> m = new HashMap<Integer, String>();
		int[] test = new int[] { 1, 2, 3 };
		System.out.println(Arrays.toString(test));
		for (Entry e : m.entrySet()) {
			System.out.println(e.getKey());
			Math.max(3, 4);
		}
	}

}
