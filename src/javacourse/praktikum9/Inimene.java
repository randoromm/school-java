package javacourse.praktikum9;

public class Inimene {

    String nimi;
	int vanus;
	
	public Inimene(String nimi, int vanus) {
		this.nimi = nimi;
		this.vanus = vanus;
	}
	
	public boolean equals(Inimene teine) {
		return teine.vanus == this.vanus
				&& this.nimi.equals(teine.nimi);
	}
	
	public void tervita() {
		TextIO.putln("Tere, minu nimi on " + nimi + ", olen " + vanus + "-aastane.");
	}
	
	@Override
	public String toString() {
		return nimi + " " + vanus;
	}
}