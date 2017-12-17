
public class Main {

	public static int oszlopMaximum(String[][] tomb1, String[][] tomb2) {
		int oszlop_max = Integer.MIN_VALUE;
		if (tomb1[0].length == tomb2[0].length) {
			oszlop_max = tomb1[0].length;
		} else if (tomb1[0].length < tomb2[0].length) {
			oszlop_max = tomb2[0].length;
		} else if (tomb2[0].length < tomb1[0].length) {
			oszlop_max = tomb1[0].length;
		} else {
			System.err.println("Adat hiba!");
			return -1;
		}
		return oszlop_max;
	}

	public static void tombKiIr(String[][] tomb) {
		for (int i = 0; i < tomb.length; i++) {
			for (int j = 0; j < tomb[0].length; j++) {
				System.out.print(tomb[i][j]);
			}
			System.out.println();
		}
	}

	public static void tombFeltoltA(String[][] tomb) {
		for (int i = 0; i < tomb.length; i++) {
			for (int j = 0; j < tomb[0].length; j++) {
				tomb[i][j] = "a";
			}
		}

	}

	public static void tombFeltoltB(String[][] tomb) {
		for (int i = 0; i < tomb.length; i++) {
			for (int j = 0; j < tomb[0].length; j++) {
				tomb[i][j] = "b";
			}
		}
	}

	public static void tombFeltoltC(String[][] tomb) {
		for (int i = 0; i < tomb.length; i++) {
			for (int j = 0; j < tomb[0].length; j++) {
				tomb[i][j] = "*";
			}
		}
	}

	public static String[][] tombOsszefuz(String[][] tomb1, String[][] tomb2) {
		String[][] tomb3 = new String[tomb1.length + tomb2.length][oszlopMaximum(tomb1, tomb2)];
		tombFeltoltC(tomb3);

		int k = 0;
		for (int i = 0; i < tomb1.length; i++) {
			for (int j = 0; j < tomb1[0].length; j++) {
				tomb3[k][j] = tomb1[i][j];
			}
			k += 2;
		}

		int m = 1;
		for (int i = 0; i < tomb2.length; i++) {
			for (int j = 0; j < tomb2[0].length; j++) {
				tomb3[m][j] = tomb2[i][j];
			}
			m += 2;
		}

		return tomb3;
	}

	public static void main(String[] args) {
		
		String[][] tomb1 = new String[3][6]; // String[10][10]; vagy String[3][6];
		String[][] tomb2 = new String[2][4]; // String[10][20]; vagy String[2][4];
		tombFeltoltA(tomb1);
		tombFeltoltB(tomb2);
		tombKiIr(tombOsszefuz(tomb1, tomb2));

	}
}
