package library;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.BookInterface;
import interfaces.LibraryInterface;
import interfaces.ReaderInterface;

public class Library implements LibraryInterface {
	
	private String name;
	private List<BookInterface> books;
	private List<ReaderInterface> readers;
	
	/** Constructor for the Library
	 * @param name
	 */
	public Library(String name, List<BookInterface> books, List<ReaderInterface> readers) {
		super();
		this.name = name;
		this.books = books;
		this.readers = readers;
	}

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
	
	public List<BookInterface> insertionSortBooks(List<BookInterface> b, String sort) {
		if(sort.equals("AUTHOR") || sort.equals("TITLE")) {
			for(int i=1; i<b.size();i++) {
				BookInterface keyElement = b.get(i);
				int position = i;
				if(sort.equals("AUTHOR")) {
					while(position>0 && b.get(position-1).getAuthor().toUpperCase().compareTo(keyElement.getAuthor().toUpperCase()) > 0) {
						b.set(position, b.get(position-1));
						position--;
					}
				} else {
					while(position>0 && b.get(position-1).getTitle().toUpperCase().compareTo(keyElement.getTitle().toUpperCase()) > 0) {
						b.set(position, b.get(position-1));
						position--;
					}
				}
				b.set(position, keyElement);
			}
		}		
		return b;
	}

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

	@Override
	public String getName() {		
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean checkStock(BookInterface book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrowBook(BookInterface book, ReaderInterface reader) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean returnBook(BookInterface book, ReaderInterface reader) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BookInterface> booksBorrowed(ReaderInterface reader) {
		// TODO Auto-generated method stub
		return null;
	}

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

	public void printError(String text) {
		System.out.println("--------------------------");
		System.out.println("> Error: " + text);
		System.out.println("--------------------------");
	}

	@Override
	public int addBook(String title, String author, int stock) {
		BookInterface b = new Book(title,author,stock);
		books.add(b);
		try {
			//Opening Reader File
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
