package praktikum5;

public class FoxDice {

	private static String turnFoxHorizontally(String foxline) {
        char[] line = foxline.toCharArray();
		String ret = "";

		for (int i = line.length - 1; i >= 0; i--) {
			char c;
			c = line[i];
			switch(c) {
				case '(' : c = ')';  break;
				case ')' : c = '(';  break;
				case '/' : c = '\\'; break;
				case '\\': c = '/';  break;
			}
			ret += c;
		}

		return ret;
	}

	public static void main (String [] args) {
		String fox[] = {
			" /\\           ",
			"(~(           ",
			" ) )     /\\_/\\",
			"( _-----_(@ @)",
			"  (       \\ / ",
			"  /|/--\\|\\ V  ",
			"  \" \"   \" \"   "
		};
		String taring[][] = {
				{
						"+-------+",
						"|       |",
						"|   *   |",
						"|       |",
						"+-------+"
				},
				{
						"+-------+",
						"|       |",
						"| *   * |",
						"|       |",
						"+-------+"
				},
				{
						"+-------+",
						"| *     |",
						"|   *   |",
						"|     * |",
						"+-------+"
				},
				{
						"+-------+",
						"| *   * |",
						"|       |",
						"| *   * |",
						"+-------+"
				},
				{
						"+-------+",
						"| *   * |",
						"|   *   |",
						"| *   * |",
						"+-------+"
				},
				{
						"+-------+",
						"| *   * |",
						"| *   * |",
						"| *   * |",
						"+-------+"
				}
		};
		int t1 = (int)(Math.random() * taring.length);
		int t2 = (int)(Math.random() * taring.length);

		for (int i = 0; i < fox.length; i++) {
			for (int j = 0; j < 1; j++) {
				System.out.print(fox[i]);
				System.out.print(" ");
			}
			if (i > 0 && i < taring[t1].length + 1) {
				System.out.print(taring[t1][i - 1] + " ");
				System.out.print(taring[t2][i - 1]);
			}
			if (i == 0 || i > taring[t1].length) {
				System.out.print("          ");
				System.out.print("         ");
			}
			System.out.print(" ");
			System.out.print(turnFoxHorizontally(fox[i]));
			System.out.println();
		}
	}
}
