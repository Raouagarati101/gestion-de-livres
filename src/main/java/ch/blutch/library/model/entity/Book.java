package ch.blutch.library.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "tbl_books", indexes = { @Index(name = "ind_title", columnList = "title") })
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT UNSIGNED")
	private int id;
	
	@Column(name = "title", columnDefinition = "VARCHAR(255)", nullable = false)
	private String title;
	
	@Column(name = "pages_number", columnDefinition = "SMALLINT UNSIGNED", nullable = true)
	private int pagesNumber;
	
	@Column(name = "publisher", columnDefinition = "VARCHAR(255)", nullable = true)
	private String publisher;
	
	@Column(name = "summary", columnDefinition = "TEXT", nullable = true)
	private String summary;
	
	@ManyToOne(targetEntity = Author.class)
	@JoinColumn(name = "author_id", columnDefinition = "INT UNSIGNED", nullable = true)
	@Cascade({CascadeType.SAVE_UPDATE})
	private Author author;
	
	@ManyToMany
	@JoinTable(name = "books_book_genres",
			joinColumns = @JoinColumn(name = "book_genre_id", columnDefinition = "INT UNSIGNED"),
			inverseJoinColumns = @JoinColumn(name = "book_id", columnDefinition = "INT UNSIGNED"))
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<BookGenre> bookGenres = new ArrayList<>();
	
	public Book() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPagesNumber() {
		return pagesNumber;
	}

	public void setPagesNumber(int pagesNumber) {
		this.pagesNumber = pagesNumber;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<BookGenre> getBookGenres() {
		return bookGenres;
	}

	public void setBookGenres(List<BookGenre> bookGenres) {
		this.bookGenres = bookGenres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
