package interfaces;

import java.util.List;

public interface LibraryInterface {
	
	/**
	 * Return a list of books. 
	 * 
	 * @param author	Name of the author to search, it can be null to search all
	 * @param book		Name of the book to search, it can be null to search all
	 * @param sortA		If true sorts authors in alphabetical order
	 * @param sortB		If true sorts books in alphabetical order
	 * @return			List of all books that match the search criteria with sorting or not
	 */
	public List<BookInterface> getBooks(String author, String book, String sort);
	
	/**
	 * Return a list of readers. 
	 * 
	 * @param reader	Name of the reader to search, it can be null to search all
	 * @param sort		If true sorts readers in alphabetical order
	 * @return			List of all readers that match the search criteria with sorting or not
	 */
	public List<ReaderInterface> getReaders(String reader, String sort);
	
	/**
	 * Return the name of the library
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * Set the name of the library.
	 * 
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * Check if a book is available for borrowing according to its stock
	 * 
	 * @param book				Book to borrow
	 * @return					true or false if available for borrowing
	 */
	public boolean checkStock(BookInterface book);

	/**
	 * Register a borrowing of a book if available.
	 * 
	 * @param book				Book to borrow
	 * @param reader			Reader who borrows
	 * @return					true or false if the book has been borrowed
	 */
	public boolean borrowBook(BookInterface book, ReaderInterface reader);
	
	/**
	 * Register the return of a book and updates the stock.
	 * 
	 * @param book				Book to return
	 * @param reader			Reader who returns
	 * @return					true or false if the book has been returned
	 */
	public boolean returnBook(BookInterface book, ReaderInterface reader);
	
	/**
	 * Returns a list of books that have been borrowed by a reader.
	 * 	 
	 * @param reader			Reader to search
	 * @return					List of all books borrowed by the reader
	 */
	public List<BookInterface> booksBorrowed(ReaderInterface reader);
	
	/**
	 * Adds a new Reader to the file
	 * @param name				Name of the reader
	 * @param address			Address of the reader
	 * @return					The ID of the new reader
	 */
	public int addReader(String name, String address);
	
	/**
	 * Adds a new Reader to the file
	 * @param title				Title name of the book
	 * @param author			Name of the author
	 * @param stock				Number of books available for borrowing
	 * @return					The ID of the new reader
	 */
	public int addBook(String title, String author, int stock);
}
