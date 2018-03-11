package popularProblems;

public class ExcelNumberToColumnName {
	public static int alphabetSize = 26;

	public static void main(String[] args) {
		int colNbr = 27;

		excelNumberToColumnName(colNbr);
	}

	private static void excelNumberToColumnName(int colNbr) {

		if (colNbr < alphabetSize) {
			System.out.print((char) ('A' + colNbr - 1));
			return;
		}

		int newColNbr = (int) (colNbr - getPrevSum(colNbr));
		int prevPwr = getHigestPower(getPrevSum(colNbr));

		if (newColNbr == 0) { // If perfect sum of squares.
			for (int i = prevPwr; i > 0; i--) {
				System.out.print((char) (alphabetSize + 'A' - 1));
			}
		} else {
			for (int i = prevPwr; i >= 0; i--) {
				int highestMultiple = getHighestMultiple(i, newColNbr); // Highest
																		// Alphabet
																		// *
																		// Square
																		// less
																		// than
																		// newColNbr
				newColNbr = (int) (newColNbr - (Math.pow(alphabetSize, i) * highestMultiple));
				System.out.print((char) ('A' + highestMultiple));

			}
		}

	}

	private static int getPrevSum(int colNbr) {
		int sum = 0;
		int i = 1;
		while (true) {
			if (sum + (int) Math.pow(alphabetSize, i) > colNbr)
				break;
			else
				sum = sum + (int) Math.pow(alphabetSize, i);
			i++;
		}
		return sum;
	}

	private static int getHighestMultiple(int i, int newColNbr) {
		int j = 0;
		while (Math.pow(alphabetSize, i) * j < newColNbr) {
			j++;
		}

		j = j - 1;
		return j;
	}

	private static int getHigestPower(int colNbr) {
		int prevPwr = 0;

		while (Math.pow(alphabetSize, prevPwr) <= colNbr) {
			prevPwr = prevPwr + 1;
		}

		prevPwr = prevPwr - 1;
		return prevPwr;
	}

}
