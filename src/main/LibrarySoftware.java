/**
 * @author Alan Arango 2020075
 */
package main;
import interfaces.LibraryInterface;
import interfaces.LibraryManagementInterface;
import library.LibraryManagement;

public class LibrarySoftware {

	public static void main(String[] args) {
		// creates a new library management
		LibraryManagementInterface lm = new LibraryManagement();
        
		// creates a new library and setups it by reading the text files
		LibraryInterface l = lm.setupLibrary("Bookland");
		//initial message
		lm.printHeader("Welcome to " + l.getName());
		
		//prints the main menu
		lm.menuLibrary(l);
	}

}
