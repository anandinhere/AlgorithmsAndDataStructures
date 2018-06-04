package matrix;

public class MatrixUtil {

	//https://www.geeksforgeeks.org/count-distinct-subsequences/
	public static void init2DMatrixTopDown(int[][] in) {

		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[0].length; j++) {
				in[i][j] = -1;
			}
		}

	}

	public static void init1DMatrixTopDown(int[] in) {

		for (int i = 0; i < in.length; i++) {

			in[i] = -1;

		}

	}

	public static void init2DMatrixBottomUp(int[][] in) {

		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[0].length; j++) {
				in[i][j] = 0;
			}
		}

	}

}
