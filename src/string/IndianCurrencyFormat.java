package string;

public class IndianCurrencyFormat {
	public static void main(String[] args) {
		String referencedFrom = new String("79879187.50");

		
		//Is "referencedFrom" guaranteed to be a number? 
		//Can the number after decimal be more than Integer.MAX? 
		//If so there needs to be more format checks here. Following code assumes the referencedFrom is a number
		
		String prefix = "₹";
		String postfix = "/-";

		int decimalIndex = referencedFrom.lastIndexOf('.');

		StringBuilder beforeDecimal = new StringBuilder();
		String afterDecimal = "";

		if (decimalIndex >= 0) {
			afterDecimal = referencedFrom.substring(decimalIndex + 1);
			if (afterDecimal.length() > 0) {
				if (Integer.parseInt(afterDecimal) == 0) {
					afterDecimal = "";
				} else {
					afterDecimal = "." + afterDecimal;
				}
			}

			beforeDecimal = new StringBuilder(referencedFrom.substring(0,
					decimalIndex));
		} else {
			// if no decimal point
			beforeDecimal = new StringBuilder(referencedFrom);
		}

		// Insert ',' starting from 4th position from the right. right to left. skip 2 positions
		// at a time as long as i is greater than 0
		if (beforeDecimal.length() > 3) {
			for (int i = beforeDecimal.length() - 3; i > 0; i = i - 2) {
				beforeDecimal.insert(i, ",");
			}
		}
		
		String result = prefix + beforeDecimal + afterDecimal + postfix;

		System.out.println(result);
	}
}
