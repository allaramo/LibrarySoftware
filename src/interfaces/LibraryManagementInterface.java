package interfaces;

public interface LibraryManagementInterface {
	/**
	 * Shows the menu of the interface.
	 * 	 
	 */	
	public LibraryInterface menuLibrary();
	
	/**
	 * Setups the library and reads the files.
	 * @param name 	Name of the Library
	 */	
	public LibraryInterface setupLibrary(String name);
}
