package ch.blutch.library.model.service;

import java.util.List;

import ch.blutch.library.model.entity.Author;

public interface AuthorService {

	public Author getAuthor(int id);
	
	public List<Author> getAuthors();
	
	public void addAuthor(Author author);
	
	public void editAuthor(Author author);
	
	public void deleteAuthor(Author author);
	
}
