package praktikum9;

import java.util.ArrayList;

/**
 * gdsagdaga
 * Created by rrommot on 14.10.16.
 */
public class InimeneMain {
    public static void main(String[] args) {
        ArrayList<Inimene> people = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            System.out.printf("Sisesta nimi: %n");
            String nimi = TextIO.getln();

            System.out.print("Sisesta vanus: ");
            int vanus = TextIO.getInt();

            people.add(new Inimene(nimi, vanus));
        }

        for (Inimene human : people) {
            human.tervita();
        }
    }
}
