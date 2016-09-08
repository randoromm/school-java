package praktikum2;

public class NameLength {
	public static void main(String[] args) {
		System.out.println("Mis su nimi on?");
		String name = TextIO.getlnString();
		int nameLength = name.length();
		System.out.println("Su koleda nime pikkus on " + nameLength + " t2hem2rki");
	}
}
