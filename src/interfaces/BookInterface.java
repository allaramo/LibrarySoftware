package interfaces;

public interface BookInterface {
	/**
	 * Returns the id of the Book
	 * 
	 * @return 	the id of the book
	 */
	public int getId();
	
	/**
	 * Sets the id of the book
	 * 
	 * @param the id of the book
	 */
	public void setId(int id);
	
	/**
	 * Returns the current counter 
	 * 
	 * @return the counter of the class
	 */
	public int getCounter();
	
	/**
	 * Sets the counter for the id
	 * 
	 * @param the counter of the class
	 */
	public void setCounter(int counter);
	
	/**
	 * Returns the title name of the Book
	 * 
	 * @return 	the title of the book
	 */
	public String getTitle();
	
	/**
	 * Sets the title of the book
	 * 
	 * @param the title of the book
	 */
	public void setTitle(String title);
	
	/**
	 * Returns the author of the Book
	 * 
	 * @return 	the author of the book
	 */
	public String getAuthor();
	
	/**
	 * Sets the author of the book
	 * 
	 * @param the author of the book
	 */
	public void setAuthor(String author);
	
	/**
	 * Returns the stock of the Book
	 * 
	 * @return 	the stock of the book
	 */
	public int getStock();
	
	/**
	 * Sets the stock of the book
	 * 
	 * @param the stock of the book
	 */
	public void setStock(int stock);
}
