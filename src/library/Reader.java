package library;

import interfaces.ReaderInterface;

public class Reader implements ReaderInterface{
	private int id;
	private static int counter;
	private String name;
	private String address;

	/** Constructor for Reader with ID (used when reading file)
	 * @param id
	 * @param name
	 * @param address	
	 */
	public Reader(int id, String name, String address) {		
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	/** Constructor for Reader without ID (used to create new Reader)
	 * @param name
	 * @param address	
	 */
	public Reader(String name, String address) {		
		this.id = counter++;
		this.name = name;
		this.address = address;
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
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		this.address = address;
	}

	@Override
	public int getCounter() {
		// TODO Auto-generated method stub
		return Reader.counter;
	}

	@Override
	public void setCounter(int counter) {
		// TODO Auto-generated method stub
		Reader.counter = counter;
	}
}
