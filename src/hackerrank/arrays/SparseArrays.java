package hackerrank.arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SparseArrays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfStr = in.nextInt();

		Map<String, Integer> strMap = new HashMap<>();
		for (int i = 0; i < noOfStr; i++) {
			String inputStr = in.next();
			if (strMap.containsKey(inputStr)) {

				strMap.put(inputStr, strMap.get(inputStr) + 1);
			} else {
				strMap.put(inputStr, 1);
			}

		}

		int noOfQ = in.nextInt();
		for (int i = 0; i < noOfQ; i++) {
			String inputStr = in.next();
			if (strMap.containsKey(inputStr)) {
				System.out.println(strMap.get(inputStr));
			}else
				System.out.println(0);
		}
	}
}
