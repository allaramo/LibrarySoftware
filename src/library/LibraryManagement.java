package library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.BookInterface;
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
	
	@Override
	public void menuLibrary() {
		// TODO Auto-generated method stub
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
						System.out.println("2.Sort a Book");
						System.out.println("3.Add a Book");
						System.out.println("4.Return");
						System.out.println("--------------------------");
						System.out.print("> Select an option: ");
						//checking valid options
						if(sc.hasNextInt()){
							suboption1 = sc.nextInt();
							switch(suboption1) {
							case 1:
								break;
							case 2:
								break;
							case 3:
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
						System.out.println("2.Sort a Reader");
						System.out.println("3.Add a Reader");
						System.out.println("4.Return");
						System.out.println("--------------------------");
						System.out.print("> Select an option: ");
						//checking valid options
						if(sc.hasNextInt()){
							suboption2 = sc.nextInt();
							switch(suboption2) {
							case 1:
								break;
							case 2:
								break;
							case 3:
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
							suboption2 = sc.nextInt();
							switch(suboption3) {
							case 1:
								break;
							case 2:
								break;
							case 3:
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
		
		//creating collections
		List<BookInterface> books = new ArrayList<>();
		List<ReaderInterface> readers = new ArrayList<>();
		
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
			System.out.println("> Error: Book's File not found");
			return null;
		} catch (IOException e){
			System.out.println("Error: " + e.toString());
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
				ReaderInterface reader = new Reader(id,readerName, address);
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
			System.out.println("Error: Book's File not found");
			return null;
		} catch (IOException e){
			System.out.println("Error: " + e.toString());
			return null;
		}
		
		if(bBook && bReader) {
			LibraryInterface library = new Library(name,books,readers);
			return library;
		} else {
			System.out.println("Error: Library wasn't created");
			return null;
		}			
	}

}
