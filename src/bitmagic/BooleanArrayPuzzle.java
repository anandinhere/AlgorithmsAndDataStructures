package bitmagic;

import java.util.Arrays;

public class BooleanArrayPuzzle {
	public static void main(String[] args) {
		
		
		int[] a = {0,1};
		// a[ a[1] ] = a[ a[0] ];
		 
		 a[ a[1] ] = a[ ~a[1] ];
	
		 
		 
		 System.out.println(Arrays.toString(a));
	}
}
