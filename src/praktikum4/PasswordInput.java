package praktikum4;

/**
 * Created by rrommot on 9.09.16.
 * Not finished, finish at home
 */
public class PasswordInput {
    public static void main(String[] args) {
        String password = "paRool123";
        int counter = 0;

        while (counter < 3) {
            System.out.println("Enter your password: ");
            String inputPassword = TextIO.getlnString();

            if (password.equals(inputPassword)) {
                System.out.println("Sisestasid õige parooli!");
                break;
            } else {
                System.out.println("Vale parool!");
                counter ++;
            }
        }
        System.out.println("Sisestasid 3x parooli valesti, proovi hiljem veel."); // not working properly
    }
}
