package library;

import interfaces.ReaderInterface;

public class Reader implements ReaderInterface{
	private int id;
	private static int counter;
	private String name;
	private String address;

	/** Constructor for Reader
	 * @param id
	 * @param name
	 * @param address	
	 */
	public Reader(int id, String name, String address) {		
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
}
