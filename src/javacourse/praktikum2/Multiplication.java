package javacourse.praktikum2;

public class Multiplication {
	public static void main(String[] args) {
		System.out.println("Sisesta esimene arv: ");
		double first = TextIO.getlnDouble();
		
		System.out.println("Sisesta teine arv: ");
		double second = TextIO.getlnDouble();
		
		double multiplication = first * second;
		System.out.println(first + " * " + second + " = " + multiplication);
	}
}
