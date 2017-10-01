package praktikum2;

public class LetterReplace {
	public static void main (String[] args) {
		System.out.println("Sisestage s6na: ");
		System.out.println(TextIO.getlnString().replace('a', '_'));

		String a = "aus";
		a = a.replace('u', 'r');
		System.out.println(a);
	}
}
