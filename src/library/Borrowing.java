package library;

import interfaces.BorrowingInterface;

public class Borrowing implements BorrowingInterface {

	private int id;
	private int idBook;
	private int idReader;
	private String status;
	private static int counter = 1;	
	
	/** Constructor with id
	 * @param id		Id of the borrowing or transaction
	 * @param idBook	Book's id
	 * @param idReader	Reader's id
	 * @param status	Status (borrowed, returned)
	 */
	public Borrowing(int id, int idBook, int idReader, String status) {
		super();
		this.id = id;
		this.idBook = idBook;
		this.idReader = idReader;
		this.status = status;
		if(Borrowing.counter<=id) {
			Borrowing.counter = id+1;
		}		
	}
	
	/** Constructor without id	
	 * @param idBook	Book's id
	 * @param idReader	Reader's id
	 * @param status	Status (borrowed, returned)
	 */
	public Borrowing(int idBook, int idReader, String status) {
		super();
		this.id = counter++;
		this.idBook = idBook;
		this.idReader = idReader;	
		this.status = status;
	}

	/**
	 * Sets the id of the Book
	 * @param id	The Id of the book
	 */
	@Override
	public void setIdBook(int id) {
		this.idBook = id;
	}

	/**
	 * Returns the Id of the book
	 * @return	Id of the book
	 */
	@Override
	public int getIdBook() {
		return idBook;
	}

	/**
	 * Sets the id of the Reader
	 * @param id	The Id of the reader
	 */
	@Override
	public void setIdReader(int id) {
		this.idReader = id;
	}

	/**
	 * Returns the Id of the reader
	 * @return	Id of the reader
	 */
	@Override
	public int getIdReader() {
		return idReader;
	}

	/**
	 * Sets the id of the Borrowing
	 * @param id	The Id of the borrowing
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the Id of the borrowing
	 * @return	Id of the borrowing
	 */
	@Override
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the status of the Borrowing
	 * @param status	The Status of the borrowing
	 */
	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Returns the Status of the borrowing
	 * @return	Status of the borrowing
	 */
	@Override
	public String getStatus() {		
		return status;
	}

	/**
	 * Returns the counter
	 * @return	The actual counter
	 */
	@Override
	public int getCounter(int counter) {
		return Borrowing.counter;
	}
}
