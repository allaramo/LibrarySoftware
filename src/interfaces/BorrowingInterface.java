package interfaces;

public interface BorrowingInterface {
	/**
	 * Sets the id of the Book
	 * @param id	The Id of the book
	 */
	public void setIdBook(int id);
	
	/**
	 * Returns the Id of the book
	 * @return	Id of the book
	 */
	public int getIdBook();
	
	/**
	 * Sets the id of the Reader
	 * @param id	The Id of the reader
	 */
	public void setIdReader(int id);
	
	/**
	 * Returns the Id of the reader
	 * @return	Id of the reader
	 */
	public int getIdReader();
	
	/**
	 * Sets the id of the Borrowing
	 * @param id	The Id of the borrowing
	 */
	public void setId(int id);
	
	/**
	 * Returns the Id of the borrowing
	 * @return	Id of the borrowing
	 */
	public int getId();
	
	/**
	 * Sets the status of the Borrowing
	 * @param status	The Status of the borrowing
	 */
	public void setStatus(String status);
	
	/**
	 * Returns the Status of the borrowing
	 * @return	Status of the borrowing
	 */
	public String getStatus();
	
	/**
	 * Returns the counter
	 * @return	The actual counter
	 */
	public int getCounter(int counter);
}
