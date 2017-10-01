package praktikum8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * fsafjasf
 * Created by rando on 10.10.16.
 */
public class AlphabetOrderNames {
    public static void main(String[] args) {
        ArrayList<String> names = generateNameArrayList();
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static ArrayList generateNameArrayList() {
        ArrayList<String> names = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String name = "template";
        while(!name.equals(" ")) {
            System.out.println("Sisesta nimi (space kui vsjo): ");
            name = input.nextLine();
            names.add(name);
        }
        Collections.sort(names);
        return names;
    }
}
