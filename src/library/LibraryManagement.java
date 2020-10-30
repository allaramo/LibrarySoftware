package library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.BookInterface;
import interfaces.BorrowingInterface;
import interfaces.LibraryInterface;
import interfaces.LibraryManagementInterface;
import interfaces.ReaderInterface;


public class LibraryManagement implements LibraryManagementInterface{
	
	/**
	 * Prints headers
	 */
	@Override
	public void printHeader(String text) {
		System.out.print("\n");	
		System.out.println("***************************");
		System.out.println("> "+ text.toUpperCase() +"    ");
		System.out.println("***************************");
	}
	
	/**
	 * Prints errors
	 */
	@Override
	public void printError(String text) {
		System.out.println("--------------------------");
		System.out.println("> Error: " + text);
		System.out.println("--------------------------");
	}
	
	/**
	 * Handles the borrowing and return of books
	 */
	@Override
	public void bookBorrowReturn(Scanner sc, LibraryInterface library, String action) {
		//asks the title and author to the user
		sc.nextLine();
		System.out.println("Input Book's Title");								
		String bTitle = sc.nextLine();
		System.out.println("Input Author's Name");								
		String bAuthor = sc.nextLine();
		BookInterface book;
		//tries to find the book with the given title and author
		List<BookInterface> searchBook = library.getBooks(bAuthor, bTitle, "");
		//if it is found it continues
		if(searchBook.size()>0) {
			book = searchBook.get(0);
			//checks if the book is available for borrowing if the action is borrow
			if((!library.checkStock(book) && action.equals("borrow"))) {
				printError("Book not available for borrowing");					
			} else {
				//if the book is available or instead we are returning the book we proceed
				//to ask for the readers name who is borrowing or returning the book
				System.out.println("Input Reader's Name");
				String rName = sc.nextLine();
				ReaderInterface reader;
				//tries to find the reader
				List<ReaderInterface> searchReader = library.getReaders(rName, "");
				if(searchReader.size()>0) {
					//if the reader is found proceeds
					reader = searchReader.get(0);
					if(action.equals("borrow")) {
						//if the action is borrow calls the borrow action
						if(library.borrowBook(book, reader)) {
							System.out.println("Borrowing registered successfully");
						} else {
							printError("Borrowing not possible. Try again.");
						}
					} else {
						//otherwise we are performing a return and we call the return action
						if(library.returnBook(book, reader)) {
							System.out.println("Book returned successfully");
						} else {
							printError("Return of the Book not possible. Try again.");
						}
					}					
				} else {										
					printError("Reader not found");
				}
			}
		} else {
			printError("Book not found: " + bTitle + ", " + bAuthor);									
		}	
	}
	
	/**
	 * Handles the menu and submenus and also the user's inputs
	 */
	@Override
	public void menuLibrary(LibraryInterface library) {
		Scanner sc = new Scanner(System.in);	
		int option = 0;
		do {
			//creating main menu
			printHeader("MAIN MENU");
			System.out.println("1.Manage Books");
			System.out.println("2.Manage Readers");
			System.out.println("3.Manage Borrowings");
			System.out.println("4.Exit");
			System.out.println("--------------------------");
			System.out.print("> Select an option: ");
			//checking valid options
			if(sc.hasNextInt()){
				option = sc.nextInt();
				switch(option){
				case 1:
					int suboption1 = 0;
					do {
						//creating sub menu
						printHeader("BOOKS MENU");	
						System.out.println("1.Search a Book");
						System.out.println("2.Sort Books");
						System.out.println("3.Add a Book");
						System.out.println("4.Return");
						System.out.println("--------------------------");
						System.out.print("> Select an option: ");
						//checking valid options
						if(sc.hasNextInt()){
							suboption1 = sc.nextInt();
							switch(suboption1) {
							case 1:
								//if we are searching we ask for the inputs
								sc.nextLine();
								System.out.println("Input the author: (input * for all authors)");
								String author = sc.nextLine();
								System.out.println("Input the title: (input * for all titles)");
								String title = sc.nextLine();
								System.out.println("Input the field by which you want to sort: (ID, TITLE, AUTHOR, NONE)");
								String sort = sc.nextLine().toUpperCase();	
								//performs the search and prints results
								System.out.println(library.getBooks(author, title, sort));
								break;
							case 2:
								//if we are sorting calls the sorting algorithm and prints
								sc.nextLine();
								System.out.println("Input the field by which you want to sort: (ID, TITLE, AUTHOR)");
								String bookSort = sc.nextLine().toUpperCase();		
								System.out.println(library.sortBooks(bookSort));
								break;
							case 3:
								//if we add a new book asks for the information
								sc.nextLine();
								System.out.println("Input the title: ");
								String bTitle = sc.nextLine();
								System.out.println("Input the author: ");
								String bAuthor = sc.nextLine();
								System.out.println("Input the stock available: ");
								int bStock = 1;
								if(sc.hasNextInt()) {
									bStock = sc.nextInt();
								}					
								//adds the book
								int rID = library.addBook(bTitle, bAuthor, bStock);
								if(rID>0) {
									System.out.println("Book added succesfully. ID: " + rID);
								} else {
									printError("Book not added. Try Again.");
								}
								break;
							case 4:
								//exit action
								break;
							default: 
								printError("Invalid Option");					
								break;
							}
						} else {
							printError("Invalid Option");
							sc.next();
						}
					}while(suboption1!=4);					
					break;
				case 2:
					int suboption2 = 0;
					do {
						//creating sub menu
						printHeader("READERS MENU");	
						System.out.println("1.Search a Reader");
						System.out.println("2.Sort Readers");
						System.out.println("3.Add a Reader");
						System.out.println("4.Return");
						System.out.println("--------------------------");
						System.out.print("> Select an option: ");
						//checking valid options
						if(sc.hasNextInt()){
							suboption2 = sc.nextInt();
							switch(suboption2) {
							case 1:
								//if we are searching we ask for the inputs
								sc.nextLine();
								System.out.println("Input the name: (input * for all readers)");
								String reader = sc.nextLine();								
								System.out.println("Input the field by which you want to sort: (ID, NAME, NONE)");
								String sort = sc.nextLine().toUpperCase();	
								//performs the search and prints results
								System.out.println(library.getReaders(reader, sort));
								break;
							case 2:
								//if we are sorting calls the sorting algorithm and prints
								sc.nextLine();
								System.out.println("Input the field by which you want to sort: (ID, NAME)");
								String readerSort = sc.nextLine().toUpperCase();		
								System.out.println(library.sortReaders(readerSort));								
								break;
							case 3:
								//if we add a new book asks for the information
								sc.nextLine();
								System.out.println("Input the name: ");
								String rName = sc.nextLine();
								System.out.println("Input the address: ");
								String rAddress = sc.nextLine();
								//adds the reader
								int rID = library.addReader(rName, rAddress);
								if(rID>0) {
									System.out.println("Reader added succesfully. ID: " + rID);
								} else {
									printError("Reader not added. Try Again.");
								}
								break;
							case 4:
								//exit action
								break;
							default: 
								printError("Invalid Option");					
								break;
							}
						} else {
							printError("Invalid Option");
							sc.next();
						}
					}while(suboption2!=4);					
					break;
				case 3:
					int suboption3 = 0;
					do {
						//creating sub menu
						printHeader("BORROWINGS MENU");		
						System.out.println("1.Borrow a Book");
						System.out.println("2.Return a Book");
						System.out.println("3.Borrowings by Reader");
						System.out.println("4.Return");
						System.out.println("--------------------------");
						System.out.print("> Select an option: ");
						//checking valid options
						if(sc.hasNextInt()){
							suboption3 = sc.nextInt();
							switch(suboption3) {
							case 1:
								//calls the borrowing algorithm
								bookBorrowReturn(sc, library, "borrow");							
								break;
							case 2:
								//calls the returning algorithm
								bookBorrowReturn(sc, library, "return");
								break;
							case 3:		
								//asks for the name of the reader to perform the search
								sc.nextLine();
								System.out.println("Input the name: ");
								String rName = sc.nextLine();
								ReaderInterface reader;
								//tries to find the reader
								List<ReaderInterface> searchReader = library.getReaders(rName, "");
								if(searchReader.size()>0) {
									//if it is found performs the search and prints
									reader = searchReader.get(0);
									System.out.println(library.booksBorrowed(reader));
								} else {
									printError("Reader not found");
								}
								break;
							case 4:
								//exit action
								break;
							default: 
								printError("Invalid Option");					
								break;
							}
						} else {
							printError("Invalid Option");
							sc.next();
						}
					}while(suboption3!=4);					
					break;
				case 4:
					break;
				default:
					printError("Invalid Option");					
					break;
				}
			} else {
				printError("Invalid Option");
				sc.next();
			}			
		}while(option!=4);
		//exiting the program and closing the scanner
		printHeader("Goodbye!");
		sc.close();
	}

	/**
	 * Handles the reading of files and setting of lists
	 */
	@Override
	public LibraryInterface setupLibrary(String name) {
		//flags to indicate if a file was read correctly or not
		boolean bBook = false;
		boolean bReader = false;
		boolean bBorrowing = false;
		
		//creating collections
		List<BookInterface> books = new ArrayList<>();
		List<ReaderInterface> readers = new ArrayList<>();
		List<BorrowingInterface> borrowings = new ArrayList<>();
		
		try {
			//Reading Book File
			FileReader frBook = new FileReader("books.txt");
			BufferedReader brBook = new BufferedReader(frBook);				
			//reading first line
			String nextLineBook = brBook.readLine();
			while(nextLineBook != null) {
				//reading information
				String[] infoBook = nextLineBook.split(":");
				int id = Integer.parseInt(infoBook[0]);
				String title = infoBook[1];
				String author = infoBook[2];
				int stock = Integer.parseInt(infoBook[3]);
				//creating new object
				BookInterface book = new Book(id, title, author, stock);
				//adding object to collection
				books.add(book);		
				//reading next line
				nextLineBook = brBook.readLine();
			}	
			//closing buffer and file
			brBook.close();
			frBook.close();	
			bBook = true;
		} catch (FileNotFoundException e){
			printError("Book's File not found");
			return null;
		} catch (IOException e){
			printError(e.toString());
			return null;
		}
		
		try {
			//Reading Reader File
			FileReader frReader = new FileReader("readers.txt");
			BufferedReader brReader = new BufferedReader(frReader);				
			//reading first line
			String nextLineReader = brReader.readLine();
			while(nextLineReader != null) {
				//reading information
				String[] infoReader = nextLineReader.split(":");
				int id = Integer.parseInt(infoReader[0]);
				String readerName = infoReader[1];
				String address = infoReader[2];
				//creating new object
				ReaderInterface reader = new Reader(id, readerName, address);
				//adding object to collection
				readers.add(reader);		
				//reading next line
				nextLineReader = brReader.readLine();
			}	
			//closing buffer and file
			brReader.close();
			frReader.close();	
			bReader = true;
		} catch (FileNotFoundException e){
			printError("Readers's File not found");			
			return null;
		} catch (IOException e){
			printError(e.toString());
			return null;
		}
		
		try {
			//Reading Borrowings File
			FileReader frBorrowing = new FileReader("borrowings.txt");
			BufferedReader brBorrowing = new BufferedReader(frBorrowing);				
			//reading first line
			String nextLineBorrowing = brBorrowing.readLine();
			while(nextLineBorrowing != null) {
				//reading information
				String[] infoBorrowing = nextLineBorrowing.split(":");
				int id = Integer.parseInt(infoBorrowing[0]);
				int idBook = Integer.parseInt(infoBorrowing[1]);
				int idReader = Integer.parseInt(infoBorrowing[2]);
				String status = infoBorrowing[3];
				//creating new object
				BorrowingInterface borrowing = new Borrowing(id, idBook, idReader, status);
				//adding object to collection
				borrowings.add(borrowing);	
				//reading next line
				nextLineBorrowing = brBorrowing.readLine();
			}	
			//closing buffer and file
			brBorrowing.close();
			frBorrowing.close();	
			bBorrowing = true;
		} catch (FileNotFoundException e){
			printError("Borrowing's File not found");			
			return null;
		} catch (IOException e){
			printError(e.toString());
			return null;
		}
		
		//if the 3 flags are true creates the library
		if(bBook && bReader && bBorrowing) {
			LibraryInterface library = new Library(name,books,readers,borrowings);
			return library;
		} else {
			printError("Library wasn't created");
			return null;
		}			
	}
}
