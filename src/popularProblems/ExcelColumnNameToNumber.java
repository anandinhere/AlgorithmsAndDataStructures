package popularProblems;

public class ExcelColumnNameToNumber {
	public static int alphabetSize = 26;

	public static void main(String[] args) {

		columnNameToNumber("AAZZ");
	}

	private static void columnNameToNumber(String string) {

		int curr = string.length() - 1;
		

		int prevRank = string.length() > 1 ? getPrevRank(curr) : 0;
		
		int rank = 0;
		for (int i = 0; i < string.length(); i++) {

			int squaresRank = (int) Math.pow(alphabetSize, curr);
			int alphaRank = (string.charAt(i) - 'A');
			rank = rank + (squaresRank * alphaRank);
			curr = curr - 1;
		}
		System.out.println(prevRank + rank + 1);
	}

	private static int getPrevRank(int curr) {
		int rank = 0;
		for (int i = curr; i > 0; i--) {
			rank = rank + (int) Math.pow(alphabetSize, i);
		}
		return rank;
	}
}
