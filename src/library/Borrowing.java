package library;

import interfaces.BorrowingInterface;

public class Borrowing implements BorrowingInterface {

	private int id;
	private int idBook;
	private int idReader;
	private String status;
	private static int counter = 1;	
	
	/**
	 * @param id
	 * @param idBook
	 * @param idReader
	 * @param status
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
	
	/**
	 * @param idBook
	 * @param idReader
	 * @param status
	 */
	public Borrowing(int idBook, int idReader, String status) {
		super();
		this.id = counter++;
		this.idBook = idBook;
		this.idReader = idReader;	
		this.status = status;
	}

	@Override
	public void setIdBook(int id) {
		this.idBook = id;
	}

	@Override
	public int getIdBook() {
		return idBook;
	}

	@Override
	public void setIdReader(int id) {
		this.idReader = id;
	}

	@Override
	public int getIdReader() {
		return idReader;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public int getCounter(int counter) {
		return Borrowing.counter;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getStatus() {		
		return status;
	}

}
