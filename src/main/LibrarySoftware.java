package main;

import interfaces.LibraryInterface;
import interfaces.LibraryManagementInterface;
import library.LibraryManagement;

public class LibrarySoftware {

	public static void main(String[] args) {
		  // create a new hotel management system
		
		
				LibraryManagementInterface lm = new LibraryManagement();
		        
				// build the library from the text file
				LibraryInterface l = lm.setupLibrary("Bookland");
				
				System.out.println("Welcome to " + l.getName() + "\n");

	}

}
