package javacourse.praktikum14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FailiLugeja {
    public static void main(String[] args) {
	    
	    // punkt tähistab jooksvat kataloogi
	    String kataloogitee = FailiLugeja.class.getResource(".").getPath();
	    
	    // otsime samast kataloogist kala.txt-nimelist faili
		File file = new File(kataloogitee + "kala.txt");
		
		try {
		    // avame faili lugemise jaoks
			BufferedReader in = new BufferedReader(new FileReader(file));
			String rida;

			// loeme failist rida haaval
			while ((rida = in.readLine()) != null) {
				System.out.println(rida);
			}
		}
		catch (FileNotFoundException e) {
		    System.out.println("Faili ei leitud: \n" + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error, jee, mingi muu error: " + e.getMessage());
		}
	}
}