package javacourse.praktikum9;

import java.util.ArrayList;

/**
 * gdsagdaga
 * Created by rrommot on 14.10.16.
 */
public class InimeneMain {
    public static void main(String[] args) {
        ArrayList<Inimene> people = new ArrayList<>();
        int peopleAmount = 5; // How names do you want to ask?

        for(int i = 0; i < peopleAmount; i++) {
            System.out.println("Sisesta nimi: ");
            String nimi = TextIO.getln();

            System.out.println("Sisesta vanus: ");
            int vanus = TextIO.getlnInt(); // getInt() - doesn't work, use getlnInt()

            people.add(new Inimene(nimi, vanus));
        }

        for (Inimene human : people) {
            human.tervita();
        }
    }
}
