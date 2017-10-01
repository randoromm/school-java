package praktikum2;

public class GroupSize {
	public static void main (String[] args) {
		System.out.println("Sisesta inimeste arv: ");
		int peopleAmount = TextIO.getlnInt();
		
		System.out.println("Sisesta grupi suurus: ");
		int groupSize = TextIO.getlnInt();
		
		int groupAmount = peopleAmount / groupSize;
		int groupLeftOvers = peopleAmount % groupSize;
		System.out.println("Saab teha " + groupAmount + " gruppi ja " + groupLeftOvers + " inimest j22b yle");
	}
}
