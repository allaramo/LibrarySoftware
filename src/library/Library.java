package library;

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
	public List<BookInterface> getBooks(String author, String book, boolean sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReaderInterface> getReaders(String reader, boolean sort) {
		// TODO Auto-generated method stub
		return null;
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
