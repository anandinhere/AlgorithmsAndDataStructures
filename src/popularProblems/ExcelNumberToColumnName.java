package popularProblems;

public class ExcelNumberToColumnName {
	public static int alphabetSize = 26;

	public static void main(String[] args) {
		int colNbr = 18954;

		excelNumberToColumnName(colNbr);
	}

	private static void excelNumberToColumnName(int colNbr) {

		int newColNbr = (int) (colNbr - getPrevSum(colNbr));
		int prevPwr = getHigestPower(getPrevSum(colNbr));

		if (newColNbr == 0) { //If perfect sum of squares.
			for (int i = prevPwr; i > 0; i--) {
				System.out.println((char) (alphabetSize + 'A' - 1));
			}
		} else {
			for (int i = prevPwr; i >= 0; i--) {
				int highestMultiple = getHighestMultiple(i, newColNbr); //Highest Alphabet * Square less than newColNbr
				newColNbr = (int) (newColNbr - (Math.pow(alphabetSize, i) * highestMultiple));
				System.out.print((char) ('A' + highestMultiple));

			}
		}

	}

	private static int getPrevSum(int colNbr) {
		int sum = 0;
		int i = 1;
		while (sum < colNbr) {
			sum = sum + (int) Math.pow(alphabetSize, i);
			i++;
		}
		return sum - (int) Math.pow(alphabetSize, i - 1);
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

		while (Math.pow(alphabetSize, prevPwr) < colNbr) {
			prevPwr = prevPwr + 1;
		}

		if (prevPwr != 0)
			prevPwr = prevPwr - 1;
		return prevPwr;
	}

}
