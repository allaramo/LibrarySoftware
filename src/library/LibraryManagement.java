package library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.BookInterface;
import interfaces.BorrowingInterface;
import interfaces.LibraryInterface;
import interfaces.LibraryManagementInterface;
import interfaces.ReaderInterface;
import java.util.Scanner;

public class LibraryManagement implements LibraryManagementInterface{
	
	@Override
	public void printHeader(String text) {
		System.out.print("\n");	
		System.out.println("***************************");
		System.out.println("> "+ text.toUpperCase() +"    ");
		System.out.println("***************************");
	}
	
	@Override
	public void printError(String text) {
		System.out.println("--------------------------");
		System.out.println("> Error: " + text);
		System.out.println("--------------------------");
	}
	
	public void bookBorrowReturn(Scanner sc, LibraryInterface library, String action) {
		sc.nextLine();
		System.out.println("Input Book's Title");								
		String bTitle = sc.nextLine();
		System.out.println("Input Author's Name");								
		String bAuthor = sc.nextLine();
		BookInterface book;
		List<BookInterface> searchBook = library.getBooks(bAuthor, bTitle, "");
		if(searchBook.size()>0) {
			book = searchBook.get(0);
			if((!library.checkStock(book) && action.equals("borrow"))) {
				printError("Book not available for borrowing");					
			} else {
				System.out.println("Input Reader's ID or Name");
				String rName = sc.nextLine();
				ReaderInterface reader;
				List<ReaderInterface> searchReader = library.getReaders(rName, "");
				if(searchReader.size()>0) {
					reader = searchReader.get(0);
					if(action.equals("borrow")) {
						if(library.borrowBook(book, reader)) {
							System.out.println("Borrowing registered successfully");
						} else {
							printError("Borrowing not possible. Try again.");
						}
					} else {
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
								sc.nextLine();
								System.out.println("Input the author: (input * for all authors)");
								String author = sc.nextLine();
								System.out.println("Input the title: (input * for all titles)");
								String title = sc.nextLine();
								System.out.println("Input the field by which you want to sort: (ID, TITLE, AUTHOR, NONE)");
								String sort = sc.nextLine().toUpperCase();								
								System.out.println(library.getBooks(author, title, sort));
								break;
							case 2:
								sc.nextLine();
								System.out.println("Input the field by which you want to sort: (ID, TITLE, AUTHOR, NONE)");
								String bookSort = sc.nextLine().toUpperCase();		
								System.out.println(library.sortBooks(bookSort));
								break;
							case 3:
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
								int rID = library.addBook(bTitle, bAuthor, bStock);
								if(rID>0) {
									System.out.println("Book added succesfully. ID: " + rID);
								} else {
									printError("Book not added. Try Again.");
								}
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
								sc.nextLine();
								System.out.println("Input the name: (input * for all readers)");
								String reader = sc.nextLine();								
								System.out.println("Input the field by which you want to sort: (ID, NAME, NONE)");
								String sort = sc.nextLine().toUpperCase();	
								System.out.println(library.getReaders(reader, sort));
								break;
							case 2:
								sc.nextLine();
								System.out.println("Input the field by which you want to sort: (ID, NAME, NONE)");
								String readerSort = sc.nextLine().toUpperCase();		
								System.out.println(library.sortReaders(readerSort));								
								break;
							case 3:
								sc.nextLine();
								System.out.println("Input the name: ");
								String rName = sc.nextLine();
								System.out.println("Input the address: ");
								String rAddress = sc.nextLine();
								int rID = library.addReader(rName, rAddress);
								if(rID>0) {
									System.out.println("Reader added succesfully. ID: " + rID);
								} else {
									printError("Reader not added. Try Again.");
								}
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
								bookBorrowReturn(sc, library, "borrow");							
								break;
							case 2:
								bookBorrowReturn(sc, library, "return");
								break;
							case 3:		
								sc.nextLine();
								System.out.println("Input the name: ");
								String rName = sc.nextLine();
								ReaderInterface reader;
								List<ReaderInterface> searchReader = library.getReaders(rName, "");
								if(searchReader.size()>0) {
									reader = searchReader.get(0);
									System.out.println(library.booksBorrowed(reader));
								} else {
									printError("Reader not found");
								}
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

	@Override
	public LibraryInterface setupLibrary(String name) {
		// TODO Auto-generated method stub	
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
		
		if(bBook && bReader && bBorrowing) {
			LibraryInterface library = new Library(name,books,readers,borrowings);
			return library;
		} else {
			printError("Library wasn't created");
			return null;
		}			
	}

}
