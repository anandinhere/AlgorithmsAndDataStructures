package bitmagic;

public class BitUtil {

	public static void print(int x) {
		System.out.println("Decimal " + x);
		System.out.println("Binary " + Integer.toBinaryString(x));

		System.out.println("-----------------");
	}

	public static void main(String[] args) {
		bitCountLookup();
	}

	public static int[][] bitCountLookup() {

		int[] origBase = { 0, 1, 1, 2 };

		// Changing base for each
		int[] base = { 0, 1, 1, 2 };

		// Amount of base element to change with in 4 rows.
		int[] baseUpdate = { 0, 1, 0, 1 };

		// Keeps
		int baseUpdate4Index = 0;
		int baseUpdate16Index = 0;

		int[][] lookUp = new int[256 / 4][4];

		int baseIndex = 0;

		for (int i = 0; i < 256 / 4; i++) {

			for (int j = 0; j < 4; j++) {
				lookUp[i][j] = base[j] + origBase[baseIndex];

				print((i * 4) + j);
				System.out.println("Function Bit Count "+CountsBitsSet.countBits((i * 4) + j));
				
				System.out.print("Lookup Value : ");
				System.out.print(lookUp[i][j] + " \n \n \n");
				
				if(lookUp[i][j]!=CountsBitsSet.countBits((i * 4) + j)){
					System.out.println("Not Equal -- Breaking");
				}
			}
			System.out.println();

			baseIndex++;

			// every 4 rows base is renewed
			if (((i + 1) % 4) == 0) {
				baseIndex = 0;

				baseUpdate4Index++;
				if (baseUpdate4Index > 3) {
					baseUpdate4Index = 0;
				}
				for (int b = 0; b < 4; b++) {
					base[b] = base[b] + baseUpdate[baseUpdate4Index];
				}

			}

			// Every 16 rows, base is renewed
			if (((i + 1) % 16) == 0) {
				baseUpdate16Index++;
				if (baseUpdate16Index > 3) {
					baseUpdate16Index = 0;
				}
				for (int b = 0; b < 4; b++) {
					base[b] = origBase[b] + origBase[baseUpdate16Index];
				}
			}

		}

		return null;

	}
}
