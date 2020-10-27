package interfaces;

public interface ReaderInterface {
	/**
	 * Returns the id of the reader
	 * 
	 * @return 	the id of the reader
	 */
	public int getId();
	
	/**
	 * Sets the id of the reader
	 * 
	 * @param the id of the reader
	 */
	public void setId(int id);
	
	/**
	 * Returns the name of the reader
	 * 
	 * @return 	the name of the reader
	 */
	public String getName();
	
	/**
	 * Sets the name of the reader
	 * 
	 * @param the name of the reader
	 */
	public void setName(String name);
	
	/**
	 * Returns the address of the reader
	 * 
	 * @return 	the address of the reader
	 */
	public String getAddress();
	
	/**
	 * Sets the address of the reader
	 * 
	 * @param the address of the reader
	 */
	public void setAddress(String address);
}
