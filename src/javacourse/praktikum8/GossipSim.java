package javacourse.praktikum8;

import java.util.Random;

/**
 * jaksga
 * Created by rando on 10.10.16.
 */
public class GossipSim {
    public static void main(String[] args) {
        String[] men = new String[] {"Mati ", "Kalle ", "Uuno "};
        String[] women = new String[] {"Katiga", "Mallega", "Pillega"};
        String[] verbs = new String[] {"M2ngib ", "Kakleb ", "R22gib "};
        System.out.println(generateGossip(men, women, verbs));
    }

    private static String generateGossip(String[] men, String[] women, String[] verbs) {
        Random rndm = new Random();
        int q1 = rndm.nextInt(3);
        int q2 = rndm.nextInt(3);
        int q3 = rndm.nextInt(3);
        return men[q1] + verbs[q2] + women[q3];
    }
}
