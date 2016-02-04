package ch.blutch.library.model.dao;

import java.util.List;

import ch.blutch.library.model.entity.BookGenre;

public interface BookGenreDao {

	public BookGenre getBookGenre(int id);
	
	public List<BookGenre> getBookGenres();
	
	public void addBookGenre(BookGenre bookGenre);
	
	public void editBookGenre(BookGenre bookGenre);
	
	public void deleteBookGenre(BookGenre bookGenre);
	
}
