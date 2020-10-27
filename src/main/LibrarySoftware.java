package main;

import interfaces.LibraryInterface;
import interfaces.LibraryManagementInterface;
import library.LibraryManagement;

public class LibrarySoftware {

	public static void main(String[] args) {
		// create a new library management system
		LibraryManagementInterface lm = new LibraryManagement();
        
		// build the library from the text file
		LibraryInterface l = lm.setupLibrary("Bookland");
		//initial message
		lm.printHeader("Welcome to " + l.getName());
		
		//printing menu
		lm.menuLibrary();
	}

}
