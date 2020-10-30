package interfaces;

import java.util.Scanner;

public interface LibraryManagementInterface {
	/**
	 * Shows the menu of the interface.
	 * 	 
	 */	
	public void menuLibrary(LibraryInterface library);
	
	/**
	 * Setups the library and reads the files.
	 * @param name 	Name of the Library
	 */	
	public LibraryInterface setupLibrary(String name);
	
	/**
	 * Prints a header
	 * @param text 	Text to print as a header
	 */	
	public void printHeader(String text);
	
	/**
	 * Prints an error
	 * @param text 	Text to print as an error
	 */	
	public void printError(String text);
	
	/**
	 * Handles the borrowing and returning of books
	 * @param sc		Scanner for inputs
	 * @param library	Library object
	 * @param action	"borrow" or "return"
	 */
	public void bookBorrowReturn(Scanner sc, LibraryInterface library, String action);
}
