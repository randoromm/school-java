package praktikum8.difSorting;

import java.util.*;

/**
 * Difficult sorting problem from praktikum 8.
 * Created by Rando Rommot on 10.10.16.
 */
public class DifficultSorting {
    public static void main(String[] args) {
        List<Sportsman> sportsmen = createSportsmenArray();
        int choice;
        boolean ascending;
        choice = askSortingInfo();
        ascending = isAscending();
        switch (choice) {
            case 1: sortName(sportsmen, ascending);
                    break;
            case 2: sortFirstRes(sportsmen, ascending);
                break;
            case 3: sortSecondRes(sportsmen, ascending);
                break;
            case 4: sortSumRes(sportsmen, ascending);
                break;
        }
        for (Sportsman i : sportsmen) {
            System.out.println(i.name + " " + i.res1 + " " + i.res2);
        }
    }

    /**
     * Creates an array of Sportsman objects.
     * Each Sportsman has a name and two results which are stored in the object.
     */
    private static List<Sportsman> createSportsmenArray() {
        List<Sportsman> sportsmen = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 3; i++){
            System.out.printf("Enter the name of #%d sports man: ", i + 1);
            String name = input.next();
            System.out.printf("Enter first result for %s: %n", name);
            double res1 = input.nextDouble();
            System.out.printf("Enter second result for %s: %n", name);
            double res2 = input.nextDouble();
            sportsmen.add(new Sportsman(res1, res2, name));
        }
        return sportsmen;
    }

    /**
     * Ask user how does he/she want to sort the list of sportsmen.
     * @return
     *      "1" - Sort by name.
     *      "2" - Sort by first result.
     *      "3" - Sort by second result.
     *      "4" - Sort by sum of results.
     */
    private static int askSortingInfo() {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        System.out.println("How do you want to sort the list: ");
        System.out.println("    1) By name. (Type \"1\")");
        System.out.println("    2) By first result. (Type \"2\")");
        System.out.println("    3) By second result. (Type \"3\")");
        System.out.println("    4) By sum of results. (Type \"3\")");

        while(choice < 1 || choice > 4) {
            System.out.println("Your choice (1 - 4): ");
            choice = input.nextInt();
        }
        return choice;
    }

    /**
     * Ask user either he/she wants to sort the sportsmen Ascending or Descending.
     * @return Boolean "True" if Ascending.
     */
    private static boolean isAscending() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while(choice < 1 || choice > 2) {
            System.out.println("Descending(1) or Ascending(2) (type \"1\" or \"2\"): ");
            choice = input.nextInt();
        }
        return choice == 2;
    }

    /**
     * Sorts sportsmen by first result.
     * @param sportsmen List of Sportsman objects.
     * @param ascending Boolean (Ascending or Descending).
     * @return Sorted list of sportsmen.
     */
    private static List<Sportsman> sortFirstRes(List<Sportsman> sportsmen, boolean ascending) {
        if(ascending) {
            sportsmen.sort((Sportsman s1, Sportsman s2) -> (int) (Math.round(s1.res1) - Math.round(s2.res1)));
        } else {
            sportsmen.sort((Sportsman s1, Sportsman s2) -> (int) (Math.round(s2.res1) - Math.round(s1.res1)));
        }
//        Arrays.sort(sportsmen, new Comparator<Sportsman>() {
//            /* compare peab tagastama numbri mis on:
//               0   kui s1 = s2
//               < 0 kui s1 < s2
//               > 0 kui s2 < s1
//             */
//            public int compare(Sportsman s1, Sportsman s2) {
//                return (int)(Math.round(s1.res1) - Math.round(s2.res1));
//            }
//        });
        return sportsmen;
    }

    /**
     * Sorts sportsmen by second result.
     * @param sportsmen List of Sportsman objects.
     * @param ascending Boolean (Ascending or Descending).
     * @return Sorted list of sportsmen.
     */
    private static List<Sportsman> sortSecondRes(List<Sportsman> sportsmen, boolean ascending) {
        if(ascending) {
            sportsmen.sort((Sportsman s1, Sportsman s2) -> (int) (Math.round(s1.res2) - Math.round(s2.res2)));
        } else {
            sportsmen.sort((Sportsman s1, Sportsman s2) -> (int) (Math.round(s2.res2) - Math.round(s1.res2)));
        }
        return sportsmen;
    }

    /**
     * Sorts sportsmen by sum of both result.
     * @param sportsmen List of Sportsman objects.
     * @param ascending Boolean (Ascending or Descending).
     * @return Sorted list of sportsmen.
     */
    private static List<Sportsman> sortSumRes(List<Sportsman> sportsmen, boolean ascending) {
        if(ascending) {
            sportsmen.sort((Sportsman s1, Sportsman s2) ->
                    (int) (Math.round(s1.res2 + s1.res1) - Math.round(s2.res2 + s2.res1)));
        } else {
            sportsmen.sort((Sportsman s1, Sportsman s2) ->
                    (int) (Math.round(s2.res2 + s2.res1) - Math.round(s1.res2 + s1.res1)));
        }
        return sportsmen;
    }

    /**
     * Sorts sportsmen by names (alphabetical order).
     * @param sportsmen List of Sportsman objects.
     * @param ascending Boolean (Ascending or Descending).
     * @return Sorted list of sportsmen.
     */
    private static List<Sportsman> sortName(List<Sportsman> sportsmen, boolean ascending) {
        if(ascending) {
            sportsmen.sort((Sportsman s1, Sportsman s2) -> s1.name.compareTo(s2.name));
        } else {
            sportsmen.sort((Sportsman s1, Sportsman s2) -> s2.name.compareTo(s1.name));
        }
        return sportsmen;
    }
}
