package helpers;

import java.util.Scanner;

/**
 * Class heps to work with console terminal
 * @author ёрий
 *
 */

public class ConsolHelper {

	/**
	 * Method for inputing a text from console terminal/
	 * @param message - a text? that will be writed in console befor 
	 * user will input his text. In common it is a discription of inputing parameter.
	 * @return
	 */
	public static String keyboard(String message) { 
	     System.out.print(message + ": "); 
	     Scanner scan = new Scanner(System.in); 
	     String rez = scan.next(); 
	      
	     return rez; 
	}

}
