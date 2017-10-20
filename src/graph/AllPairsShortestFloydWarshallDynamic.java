package graph;

//Reference - https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
//https://en.wikipedia.org/wiki/Shortest-path_tree

public class AllPairsShortestFloydWarshallDynamic {
	public static void main(String[] args) {

		int[][] adjMatrix = { { 9999, 10, 9999, 4, 9999 },
				{ 9999, 9999, 9999, 9999, -1 }, { 1, 9999, 9999, 9999, 5 },
				{ 9999, -3, 9999, 9999, 3 }, { 9999, 9999, 9999, 9999, 9999 } };

		int[][] next = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (adjMatrix[i][j] != 9999) {
					next[i][j] = j;
				} else
					next[i][j] = -1;
			}
		}

		
		print(adjMatrix,next);
		System.out.println("********************");
		
		
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {

					int base = adjMatrix[i][j];
					int temp = adjMatrix[i][k] + adjMatrix[k][j];

					if (temp < base) {
						adjMatrix[i][j] = temp; // this is the new shortest path
						next[i][j] = next[i][k]; //this is the new vertex along the shortest path
					}
				}
			}

			print(adjMatrix,next);
		}

		

		int start = 2;
		int end = 4;
		while (start != end) {
			start = next[start][end];
			if (start == -1)
				break;

			System.out.println(start);
		}

	}

	private static void print(int[][] adjMatrix, int[][] next) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				System.out.print(adjMatrix[i][j] + "		");
			}
			System.out.println();
		}
		
		System.out.println("\n\n\n");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				System.out.print(next[i][j] + "     ");
			}
			System.out.println();
		}

		System.out.println("\n\n\n");

	}
}
