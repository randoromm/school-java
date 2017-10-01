package olympiaad;

/**
 * Mingi lambine olümpiaadi ül, mille Oliver leidis
 * Created by Rando on 22.10.2016.
 */
public class Medals {
    public static void main(String[] args) {
        Data d = new Data("medalidsis.txt");
        d.printResult();
        System.out.println(d.result);
    }
}
