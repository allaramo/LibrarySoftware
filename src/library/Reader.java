package library;

import interfaces.ReaderInterface;

public class Reader implements ReaderInterface{
	private int id;
	private static int counter = 1;
	private String name;
	private String address;

	/** Constructor for Reader with ID (used when reading file)
	 * @param id
	 * @param name
	 * @param address	
	 */
	public Reader(int id, String name, String address) {	
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		if(Reader.counter<=id) {
			Reader.counter = id+1;
		}		
	}
	
	/** Constructor for Reader without ID (used to create new Reader)
	 * @param name
	 * @param address	
	 */
	public Reader(String name, String address) {	
		super();
		this.id = counter++;
		this.name = name;
		this.address = address;
	}

	/**
	 * Returns the id of the reader
	 * 
	 * @return 	the id of the reader
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the reader
	 * 
	 * @param the id of the reader
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
	public int getCounter() {
		return Reader.counter;
	}

	/**
	 * Sets the counter for the id
	 * 
	 * @param the counter of the class
	 */
	@Override
	public void setCounter(int counter) {
		Reader.counter = counter;
	}

	/**
	 * Returns the name of the reader
	 * 
	 * @return 	the name of the reader
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the reader
	 * 
	 * @param the name of the reader
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the address of the reader
	 * 
	 * @return 	the address of the reader
	 */
	@Override
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address of the reader
	 * 
	 * @param the address of the reader
	 */
	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Prints the object
	 * @return 	String with all fields
	 */
	@Override
	public String toString() {
		return "\n" + id + ", " + name + ", " + address;
	}
	
}
