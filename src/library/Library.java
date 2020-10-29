package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.BookInterface;
import interfaces.BorrowingInterface;
import interfaces.LibraryInterface;
import interfaces.ReaderInterface;

public class Library implements LibraryInterface {
	
	private String name;
	private List<BookInterface> books;
	private List<ReaderInterface> readers;
	private List<BorrowingInterface> borrowings;
	
	/** Constructor for the Library
	 * @param name
	 */
	public Library(String name, List<BookInterface> books, List<ReaderInterface> readers, List<BorrowingInterface> borrowings) {
		super();
		this.name = name;
		this.books = books;
		this.readers = readers;
		this.borrowings = borrowings;
	}

	/**
	 * Gets all the books filtered by author, title, both or without filters.
	 * It also allows to sort by id, title and author
	 */
	@Override
	public List<BookInterface> getBooks(String author, String title, String sort) {
		//searching algorithm
		List<BookInterface> search = new ArrayList<>();		
		if(author.equals("*") && title.equals("*")) {
			//if both parameters are * copies books to search 
			search = books;
		} else {
			for(BookInterface b : books) {	
				//searches all the books with the same title name
				if(author.equals("*") && !title.equals("*")) {
					if(title.toUpperCase().equals(b.getTitle().toUpperCase())) {
						search.add(b);
					}	
				} else {
					//searches all the books with the same author
					if(!author.equals("*") && title.equals("*")) {
						if(author.toUpperCase().equals(b.getAuthor().toUpperCase())) {
							search.add(b);
						}
					} else {
						//searches all the books with the same title name and with the same author
						if(author.toUpperCase().equals(b.getAuthor().toUpperCase()) && title.toUpperCase().equals(b.getTitle().toUpperCase())) {
							search.add(b);
						}
					}
				}
			}					
		}		
		//sorting algorithm
		return insertionSortBooks(search, sort);
	}
	
	/**
	 * Sorting algorithm for Books
	 */
	@Override
	public List<BookInterface> insertionSortBooks(List<BookInterface> b, String sort) {
		//sorts only if the user inputs author, title or id
		if(sort.equals("AUTHOR") || sort.equals("TITLE") || sort.equals("ID")) {
			for(int i=1; i<b.size();i++) {
				BookInterface keyElement = b.get(i);
				int position = i;
				//sort by author
				if(sort.equals("AUTHOR")) {
					while(position>0 && b.get(position-1).getAuthor().toUpperCase().compareTo(keyElement.getAuthor().toUpperCase()) > 0) {
						b.set(position, b.get(position-1));
						position--;
					}
				} else {
					//sort by title
					if(sort.equals("TITLE")) {
						while(position>0 && b.get(position-1).getTitle().toUpperCase().compareTo(keyElement.getTitle().toUpperCase()) > 0) {
							b.set(position, b.get(position-1));
							position--;
						}
					} else {
						//sort by id
						while(position>0 && b.get(position-1).getId() > keyElement.getId()) {
							b.set(position, b.get(position-1));
							position--;
						}
					}
				}
				b.set(position, keyElement);
			}
		}		
		return b;
	}
	
	/**
	 * Sorts the Books by id, author and title but saves the sort into the file
	 */
	@Override
	public List<BookInterface> sortBooks(String sort){
		books = insertionSortBooks(books, sort);
		try {
			//Opening Books File
			FileWriter fwBook = new FileWriter("books.txt");
			BufferedWriter bwBook = new BufferedWriter(fwBook);		
			//Writing text
			for(BookInterface b : books) {
				bwBook.write(b.getId()+":"+b.getTitle()+":"+b.getAuthor()+":"+b.getStock());
				bwBook.newLine();
			}			
			//closing buffer and file;
			bwBook.close();
			fwBook.close();		
		} catch (FileNotFoundException e){
			printError("Book's File not found");
		} catch (IOException e){
			printError(e.toString());
		}
		return books;
	}

	/**
	 * Gets all the readers filtered or not by name.
	 * It also allows to sort by id and name
	 */
	@Override
	public List<ReaderInterface> getReaders(String reader, String sort) {
		//searching algorithm
		List<ReaderInterface> search = new ArrayList<>();
		if(reader.equals("*")) {
			//if both parameters are * copies books to search 
			search = readers;
		} else {
			for(ReaderInterface r : readers) {	
				//searches all the readers with the same name				
				if(reader.toUpperCase().equals(r.getName().toUpperCase())) {
					search.add(r);
				}
			}					
		}
		//sorting algorithm
		return insertionSortReaders(search, sort);
	}
	
	/**
	 * Sorting algorithm for Readers
	 */
	@Override
	public List<ReaderInterface> insertionSortReaders(List<ReaderInterface> r, String sort) {
		if(sort.equals("ID") || sort.equals("NAME")) {
			for(int i=1; i<r.size();i++) {
				ReaderInterface keyElement = r.get(i);
				int position = i;
				if(sort.equals("NAME")) {
					while(position>0 && r.get(position-1).getName().toUpperCase().compareTo(keyElement.getName().toUpperCase()) > 0) {
						r.set(position, r.get(position-1));
						position--;
					}
				} else {
					while(position>0 && r.get(position-1).getId() > keyElement.getId()) {
						r.set(position, r.get(position-1));
						position--;
					}
				}
				r.set(position, keyElement);
			}
		}		
		return r;
	}

	/**
	 * Sorts the Readers by id or name but saves the sort into the file
	 */
	@Override
	public List<ReaderInterface> sortReaders(String sort){
		readers = insertionSortReaders(readers, sort);
		try {
			//Opening Readers File
			FileWriter fwReader = new FileWriter("readers.txt");
			BufferedWriter bwReader = new BufferedWriter(fwReader);		
			//Writing text
			for(ReaderInterface r : readers) {
				bwReader.write(r.getId()+":"+r.getName()+":"+r.getAddress());
				bwReader.newLine();
			}			
			//closing buffer and file;
			bwReader.close();
			fwReader.close();		
		} catch (FileNotFoundException e){
			printError("Reader's File not found");
		} catch (IOException e){
			printError(e.toString());
		}
		return readers;
	}
	
	/**
	 * Returns the name of the library
	 */
	@Override
	public String getName() {		
		return name;
	}

	/**
	 * Sets the name of the library
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Checks the stock of a Book to see if it is available for borrowing
	 */
	@Override
	public boolean checkStock(BookInterface book) {
		if(book.getStock()>0) {
			return true;
		}
		return false;
	}

	/**
	 * Registers the borrowing and saves it on a File. Updates the stock in the Book's file
	 */
	@Override
	public boolean borrowBook(BookInterface book, ReaderInterface reader) {
		BorrowingInterface b = new Borrowing(book.getId(),reader.getId(),"borrowed");
		borrowings.add(b);
		//updates the stock in the list
		for(BookInterface bb : books) {
			if(bb.getId()==book.getId()) {
				bb.setStock(bb.getStock()-1);
				break;
			}
		}
		
		boolean writeBook = false;
		boolean writeBorrowing = false;
		//writes in files
		try {
			//Opening Borrowing File
			FileWriter fwBorrowing = new FileWriter("borrowings.txt",true);
			BufferedWriter bwBorrowing = new BufferedWriter(fwBorrowing);		
			//Appending text
			bwBorrowing.append(b.getId()+":"+b.getIdBook()+":"+b.getIdReader()+":"+b.getStatus());
			bwBorrowing.newLine();
			//closing buffer and file;
			bwBorrowing.close();
			fwBorrowing.close();
			writeBorrowing = true;
		} catch (FileNotFoundException e){
			printError("Borrowing's File not found");
		} catch (IOException e){
			printError(e.toString());
		}
		        
        try
        {
        	//Reading Book File
			FileReader frBook = new FileReader("books.txt");
			BufferedReader brBook = new BufferedReader(frBook);	 
            String oldContent = "";                     
            String line = brBook.readLine();             
            while (line != null) 
            {
            	oldContent = oldContent + line + System.lineSeparator();                 
                line = brBook.readLine();
            }          
            String oldLine = String.valueOf(book.getId()) + ":" + book.getTitle() + ":" + book.getAuthor() + ":";
            String newLine = oldLine + String.valueOf(book.getStock());
            oldLine = oldLine + String.valueOf(book.getStock()+1);
            String newContent = oldContent.replaceFirst(oldLine,newLine);
            frBook.close();
            FileWriter fwBook = new FileWriter("books.txt"); 
            fwBook.write(newContent);
            brBook.close();
            fwBook.close();
            writeBook = true;
        } catch (FileNotFoundException e){
			printError("Book's File not found");
		} catch (IOException e){
			printError(e.toString());
		}	
		
		if(writeBook && writeBorrowing) {
			return true;
		}
		return false;	
	}

	/**
	 * Registers the return of a book and saves it on a File. Updates the stock in the Book's file
	 */
	@Override
	public boolean returnBook(BookInterface book, ReaderInterface reader) {
		BorrowingInterface borrowing = null;
		for(BorrowingInterface b : borrowings) {
			if(b.getIdBook() == book.getId() && b.getIdReader() == reader.getId() && b.getStatus().equals("borrowed")) {
				b.setStatus("returned");
				borrowing = b;
				break;
			}
		}
		if(borrowing==null) {
			return false;
		}
		//updates the stock in the list
		for(BookInterface bb : books) {
			if(bb.getId()==book.getId()) {
				bb.setStock(bb.getStock()+1);
				break;
			}
		}
		
		boolean writeBook = false;
		boolean writeBorrowing = false;
		//writes in files
		try
        {
        	//Reading Borrowings File
			FileReader frBorrowing = new FileReader("borrowings.txt");
			BufferedReader brBorrowing = new BufferedReader(frBorrowing);	 
            String oldContent = "";                     
            String line = brBorrowing.readLine();             
            while (line != null) 
            {
            	oldContent = oldContent + line + System.lineSeparator();                 
                line = brBorrowing.readLine();
            }          
            String oldLine = String.valueOf(borrowing.getId()) + ":" + String.valueOf(borrowing.getIdBook()) + ":" + String.valueOf(borrowing.getIdReader()) + ":";
            String newLine = oldLine + "returned";
            oldLine = oldLine + "borrowed";
            String newContent = oldContent.replaceFirst(oldLine,newLine);
            frBorrowing.close();
            FileWriter fwBorrowing = new FileWriter("borrowings.txt"); 
            fwBorrowing.write(newContent);
            brBorrowing.close();
            fwBorrowing.close();
            writeBorrowing = true;
        } catch (FileNotFoundException e){
			printError("Borrowing's File not found");
		} catch (IOException e){
			printError(e.toString());
		}	
		        
        try
        {
        	//Reading Book File
			FileReader frBook = new FileReader("books.txt");
			BufferedReader brBook = new BufferedReader(frBook);	 
            String oldContent = "";                     
            String line = brBook.readLine();             
            while (line != null) 
            {
            	oldContent = oldContent + line + System.lineSeparator();                 
                line = brBook.readLine();
            }          
            String oldLine = String.valueOf(book.getId()) + ":" + book.getTitle() + ":" + book.getAuthor() + ":";
            String newLine = oldLine + String.valueOf(book.getStock());
            oldLine = oldLine + String.valueOf(book.getStock()-1);
            String newContent = oldContent.replaceFirst(oldLine,newLine);
            frBook.close();
            FileWriter fwBook = new FileWriter("books.txt"); 
            fwBook.write(newContent);
            brBook.close();
            fwBook.close();
            writeBook = true;
        } catch (FileNotFoundException e){
			printError("Book's File not found");
		} catch (IOException e){
			printError(e.toString());
		}	
		
		if(writeBook && writeBorrowing) {
			return true;
		}
		return false;	
	}

	@Override
	public String booksBorrowed(ReaderInterface reader) {
		String list = "";
		for(BorrowingInterface bb : borrowings) {
			if(bb.getIdReader()==reader.getId()) {
				for(BookInterface b : books) {
					if(b.getId()==bb.getIdBook()) {
						list = list + "Borrowing No." + bb.getId() + "> " + b.getTitle() + ", " + b.getAuthor() + "\n";
						break;
					}
				}				
			}
		}
		if(list.equals("")) {
			list = "No books borrowed yet";
		}
		return list;
	}

	/**
	 * Inserts a new Reader into the list and into the file
	 */
	@Override
	public int addReader(String name, String address) {
		ReaderInterface r = new Reader(name,address);
		readers.add(r);
		try {
			//Opening Reader File
			FileWriter fwReader = new FileWriter("readers.txt",true);
			BufferedWriter bwReader = new BufferedWriter(fwReader);		
			//Appending text
			bwReader.append(r.getId()+":"+name+":"+address);
			bwReader.newLine();
			//closing buffer and file;
			bwReader.close();
			fwReader.close();
			return r.getId();
		} catch (FileNotFoundException e){
			printError("Reader's File not found");
		} catch (IOException e){
			printError(e.toString());
		}
		return 0;
	}

	/**
	 * Prints in console an error
	 * @param text	Error text to print
	 */
	@Override
	public void printError(String text) {
		System.out.println("--------------------------");
		System.out.println("> Error: " + text);
		System.out.println("--------------------------");
	}

	/**
	 * Inserts a new Book into the list and into the file
	 */
	@Override
	public int addBook(String title, String author, int stock) {
		BookInterface b = new Book(title,author,stock);
		books.add(b);
		try {
			//Opening Book File
			FileWriter fwBook = new FileWriter("books.txt",true);
			BufferedWriter bwBook = new BufferedWriter(fwBook);		
			//Appending text
			bwBook.append(b.getId()+":"+title+":"+author+":"+stock);
			bwBook.newLine();
			//closing buffer and file;
			bwBook.close();
			fwBook.close();
			return b.getId();
		} catch (FileNotFoundException e){
			printError("Book's File not found");
		} catch (IOException e){
			printError(e.toString());
		}
		return 0;
	}
}
