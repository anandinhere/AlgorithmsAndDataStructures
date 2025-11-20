package graph;
/*
 * REference : http://www.geeksforgeeks.org/find-number-of-islands/
 */
public class NumberOfIslandsInMatrix {
	public static void main(String[] args) {
		int[][] graph = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

		int noOfIslands = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if ((graph[i][j]) == 1) {

					dfs(i, j, graph);
						noOfIslands++;
				}

			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("No Of Islands " +noOfIslands);
	}

	/**
	 * 
	 * @param i
	 * @param j
	 * @param graph
	 * 
	 *            1 means valid; 2 means visited; 0 means invalid
	 */

	private static void dfs(int i, int j, int[][] graph) {

		if (!(i >= 0 && i < 5 && j >= 0 && j < 5))
			return;

		if ((graph[i][j]) == 0 || graph[i][j] == 2) {
			return;
		}
		if ((graph[i][j]) == 1) {
			graph[i][j] = 2;
		}

		for (int n = 0; n < 8; n++) {
			dfs(i - 1, j - 1, graph);
			dfs(i - 1, j, graph);
			dfs(i - 1, j + 1, graph);

			dfs(i, j - 1, graph);
			dfs(i, j + 1, graph);

			dfs(i + 1, j - 1, graph);
			dfs(i + 1, j, graph);
			dfs(i + 1, j + 1, graph);
		}
	}

}
