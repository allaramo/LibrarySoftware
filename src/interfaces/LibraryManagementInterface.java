package interfaces;

public interface LibraryManagementInterface {
	/**
	 * Shows the menu of the interface.
	 * 	 
	 */	
	public void menuLibrary(LibraryInterface library);
	
	/**
	 * Setups the library and reads the files.
	 * @param name 	Name of the Library
	 */	
	public LibraryInterface setupLibrary(String name);
	
	/**
	 * Prints a header
	 * @param text 	Text to print as a header
	 */	
	public void printHeader(String text);
	
	/**
	 * Prints an error
	 * @param text 	Text to print as an error
	 */	
	public void printError(String text);
	
}
