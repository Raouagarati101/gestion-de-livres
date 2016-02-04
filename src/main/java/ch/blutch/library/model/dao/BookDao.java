package ch.blutch.library.model.dao;

import java.util.List;

import ch.blutch.library.model.entity.Book;

public interface BookDao {

	public List<Book> getBooks();

	public Book getBook(int bookId);
	
	public void addBook(Book book);
	
	public void editBook(Book book);
	
	public void deleteBook(Book book);
	
}
