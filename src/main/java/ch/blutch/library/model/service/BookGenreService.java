package ch.blutch.library.model.service;

import java.util.List;

import ch.blutch.library.model.entity.Book;
import ch.blutch.library.model.entity.BookGenre;

public interface BookGenreService {

	public BookGenre getBookGenre(int id);
	
	public List<BookGenre> getBookGenres();
	
	public void addBookGenre(BookGenre bookGenre);
	
	public void editBookGenre(BookGenre bookGenre);
	
	public void deleteBookGenre(BookGenre bookGenre);
	
}
