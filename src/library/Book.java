package library;

import interfaces.BookInterface;

public class Book implements BookInterface {

	private int id;
	private static int counter;
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
	}
	
	/** Constructor for Book (used to create a new book) 
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

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return author;
	}

	@Override
	public void setAuthor(String author) {
		// TODO Auto-generated method stub
		this.author = author;
	}

	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return stock;
	}

	@Override
	public void setStock(int stock) {
		// TODO Auto-generated method stub
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", stock=" + stock + "]";
	}

	@Override
	public void setCounter(int counter) {
		// TODO Auto-generated method stub
		Book.counter = counter;
	}

	@Override
	public int getCounter() {
		// TODO Auto-generated method stub
		return counter;
	}

}
