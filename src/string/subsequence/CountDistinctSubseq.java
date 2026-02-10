package string.subsequence;

import matrix.MatrixUtil;
import java.util.*;

import java.util.LinkedList;

public class CountDistinctSubseq {

	static String str = "abcde";
	static int[] lastIndexArr = new int[256];
	// Golden Rule - DP Matrix size always 1 greater than input
	static int[] dpMatrix = new int[str.length() + 1];

	// https://www.geeksforgeeks.org/count-distinct-subsequences/
	public static void main(String[] args) {

		MatrixUtil.init1DMatrixTopDown(dpMatrix);
		MatrixUtil.init1DMatrixTopDown(lastIndexArr);
		// lastIndex[str.charAt(0)] = 0;
		int count = 0;

		//for (int i = 0; i <= str.length(); i++) {
			count = getCountRecursion(0);
			System.out.println(count);
		//}

	}


	private static int getCountRecursion(int i) {

		if (i == str.length()) {
			return 1;
		}

		int count = 2 * getCountRecursion(i + 1);
		int lastIndex = findCharIndex(str.charAt(i),i+1);
		if (lastIndex!=-1){

                count = count - (getCountRecursion(lastIndex+1) );
                //removing all subseq starting after next occurence. that is nothing
                // but count( index of char after next occurence)

        }

		return count;
	}

	private static int findCharIndex(char in,int start) {


		while(start<str.length()){
			if(str.charAt(start)==in){
                return start;
			}
			start ++;
		}
		return -1;
	}

	private static int getCountDPTopDown(int i) {
		if (dpMatrix[i] != -1) {
			return dpMatrix[i];
		}

		if (i == 0) {
			dpMatrix[i] = 1;
			return 1;
		}

		int count = 2 * getCountDPTopDown(i - 1);
		// Because we are starting with one index ahead
		int lastIndex = lastIndexArr[str.charAt(i - 1)];
		if (lastIndex != -1) {
			count = count - getCountDPTopDown(lastIndex);
		}

		// Because we are starting with one index ahead

		lastIndexArr[str.charAt(i - 1)] = i - 1;
		dpMatrix[i] = count;
		return count;
	}

}
