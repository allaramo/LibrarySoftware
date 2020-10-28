package library;

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
	public List<BookInterface> getBooks(String author, String title, boolean sort) {
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
		System.out.println(search);
		//sorting algorithm
		return search;
	}

	@Override
	public List<ReaderInterface> getReaders(String reader, boolean sort) {
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
		System.out.println(search);
		//sorting algorithm
		return search;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
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

}
