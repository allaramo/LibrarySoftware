package library;

import interfaces.BookInterface;

public class Book implements BookInterface {

	private int id;
	private static int counter = 1;
	private String title;
	private String author;
	private int stock;
	
	/** Constructor for Book with ID (used when reading file)
	 * @param id
	 * @param title
	 * @param author
	 * @param stock
	 */
	public Book(int id, String title, String author, int stock) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.stock = stock;
		if(Book.counter<=id) {
			Book.counter = id+1;
		}	
	}
	
	/** Constructor for Book without ID (used to create a new book) 
	 * @param title
	 * @param author
	 * @param stock
	 */
	public Book(String title, String author, int stock) {
		super();
		this.id = counter++;
		this.title = title;
		this.author = author;
		this.stock = stock;
	}

	/**
	 * Returns the id of the Book
	 * 
	 * @return 	the id of the book
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the book
	 * 
	 * @param the id of the book
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the current counter 
	 * 
	 * @return the counter of the class
	 */
	@Override
	public void setCounter(int counter) {
		Book.counter = counter;
	}
	
	/**
	 * Sets the counter for the id
	 * 
	 * @param the counter of the class
	 */
	@Override
	public int getCounter() {
		return counter;
	}
	/**
	 * Returns the title name of the Book
	 * 
	 * @return 	the title of the book
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the book
	 * 
	 * @param the title of the book
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the author of the Book
	 * 
	 * @return 	the author of the book
	 */
	@Override
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author of the book
	 * 
	 * @param the author of the book
	 */
	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Returns the stock of the Book
	 * 
	 * @return 	the stock of the book
	 */
	@Override
	public int getStock() {
		return stock;
	}

	/**
	 * Sets the stock of the book
	 * 
	 * @param the stock of the book
	 */
	@Override
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	/**
	 * Prints the object
	 * @return 	String with all fields
	 */
	@Override
	public String toString() {
		return "\n" + id + ", " + title + ", " + author + ", " + stock;	
	}
}
