package library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.BookInterface;
import interfaces.LibraryInterface;
import interfaces.LibraryManagementInterface;

public class LibraryManagement implements LibraryManagementInterface{

	@Override
	public LibraryInterface menuLibrary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LibraryInterface setupLibrary(String name) {
		// TODO Auto-generated method stub	
				try {
					FileReader f = new FileReader("books.txt");
					BufferedReader br = new BufferedReader(f);					
					List<BookInterface> books = new ArrayList<>();
					String nextLine = br.readLine();
					while(nextLine != null) {
						String[] params = nextLine.split(":");
						int id = Integer.parseInt(params[0]);
						String title = params[1];
						String author = params[2];
						int stock = Integer.parseInt(params[3]);
						BookInterface b = new Book(id, title, author, stock);
						books.add(b);						
						nextLine = br.readLine();
					}		
					LibraryInterface l = new Library(name);
					br.close();
					return l;
				} catch (FileNotFoundException e){
					System.out.println("File not found");
					return null;
				} catch (IOException e){
					System.out.println("Error: " + e.toString());
					return null;
				}	
	}

}
