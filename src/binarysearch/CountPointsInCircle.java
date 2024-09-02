package binarysearch;



//JAVA Code for Queries on count of 
//points lie inside a circle 
import java.util.*; 

class CountPointsInCircle { 

	// Computing the x^2 + y^2 for each given points 
	// and sorting them. 
	public static void preprocess(int p[], int x[], 
								int y[], int n) 
	{ 
		for (int i = 0; i < n; i++) 
			p[i] = x[i] * x[i] + y[i] * y[i]; 

		Arrays.sort(p); 
	} 

	// Return count of points lie inside or on 
	// circumference of circle using binary 
	// search on p[0..n-1] 
	public static int query(int p[], int n, int rad) 
	{ 
		int start = 0, end = n - 1; 
		int ans = 0;
		while (start <= end) { 
			int mid = (start + end) / 2; 
			double tp = Math.sqrt(p[mid]); 

			if (tp > (rad * 1.0)) 
				end = mid - 1; 
			else
				if(tp <= (rad * 1.0)) {
					ans = mid + 1;
					start = mid + 1;
				}
				 
		} 
		System.out.println("start " +start +"\nend " + end);

		return ans;
		
//		double tp1 = Math.sqrt(p[start]); 
//		double tp2 = Math.sqrt(p[end]); 
//
//		if (tp1 > (rad * 1.0)) 
//			return 0; 
//		else if (tp2 <= (rad * 1.0)) 
//			return end + 1; 
//		else
//			return start + 1; 
	} 

	/* Driver program to test above function */
	public static void main(String[] args) 
	{ 
		int x[] = { 1, 2, 3, -1, 4 }; 
		int y[] = { 1, 2, 3, -1, 4 }; 
		int n = x.length; 

		// Compute distances of all points and keep 
		// the distances sorted so that query can 
		// work in O(logn) using Binary Search. 
		int p[] = new int[n]; 
		preprocess(p, x, y, n); 

		// Print number of points in a circle of 
		// radius 3. 
		System.out.println(query(p, n, 3)); 

		// Print number of points in a circle of 
		// radius 32. 
		System.out.println(query(p, n, 32)); 
	} 
} 
//This code is contributed by Arnav Kr. Mandal. 

