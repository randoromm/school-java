package praktikum9;

/**
 * gfshgd
 * Created by rrommot on 14.10.16.
 */
public class CapitalShit {
    public static void main(String[] args) {

        String word;

        String result = "";

        System.out.println("Eu kirjuta mingi sõna blä");
        word = TextIO.getln();

        for (int a = 0; a < word.length(); a++) {
            if ( a == word.length() -1){
                result += word.charAt(a);
            }
            else{
                result += word.charAt(a) + "-";


            }

        }
        result = result.toUpperCase();
        System.out.println(result);
    }
}
