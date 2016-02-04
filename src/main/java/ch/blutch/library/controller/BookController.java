package ch.blutch.library.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ch.blutch.library.model.entity.Author;
import ch.blutch.library.model.entity.Book;
import ch.blutch.library.model.entity.BookGenre;
import ch.blutch.library.model.service.AuthorService;
import ch.blutch.library.model.service.BookGenreService;
import ch.blutch.library.model.service.BookService;
import ch.blutch.library.model.service.ChangeLoggerService;
import ch.blutch.library.model.service.impl.ChangeLoggerServiceImpl;

@ManagedBean
@ViewScoped
@Controller
@Scope("view")
public class BookController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("bookServiceImpl")
	private BookService bookService;
	
	@Autowired
	@Qualifier("authorServiceImpl")
	private AuthorService authorService;
	
	@Autowired
	@Qualifier("bookGenreServiceImpl")
	private BookGenreService bookGenreService;
	
	@Autowired
	@Qualifier("changeLoggerServiceImpl")
	private ChangeLoggerService changeLoggerService;
	
	private ResourceBundle msg;

	private List<Book> books;
	private int bookId;
	private Book book;
	private Book formBook;
	
	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		msg = context.getApplication().getResourceBundle(context, "msg");
	}

	public void initIndexAction() {
		books = bookService.getBooks();
	}
	
	public void initViewAction() throws IOException {
		book = bookService.getBook((int) bookId);

		if (book == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.setResponseStatus(404);
			ec.redirect(ec.getRequestContextPath() + "/404");
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	public void initAddAction() {
		formBook = new Book();
	}
	
	public void initEditAction() throws IOException {
		formBook = bookService.getBook((int) bookId);

		if (formBook == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.setResponseStatus(404);
			ec.redirect(ec.getRequestContextPath() + "/404");
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	public void initDeleteAction() throws IOException {
		book = bookService.getBook((int) bookId);

		if (book == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.setResponseStatus(404);
			ec.redirect(ec.getRequestContextPath() + "/404");
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	public String addBook() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		bookService.addBook(formBook);
		context.addMessage(null, new FacesMessage(msg.getString("book.add.flashbag")));
		this.setBookId(formBook.getId());	// Initialise le paramètre pour la navigation Pretty faces
		changeLoggerService.log(ChangeLoggerServiceImpl.ADD, "Livres");
		
		return "pretty:book-view";
	}
	
	public String editBook() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		bookService.editBook(formBook);
		context.addMessage(null, new FacesMessage(msg.getString("book.edit.flashbag")));
		changeLoggerService.log(ChangeLoggerServiceImpl.EDIT, "Livres");
		
		return "pretty:book-view";
	}
	
	public String deleteBook() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		bookService.deleteBook(book);
		context.addMessage(null, new FacesMessage(msg.getString("book.delete.flashbag")));
		changeLoggerService.log(ChangeLoggerServiceImpl.DELETE, "Livres");
		
		return "pretty:index";
	}
	
	public List<Author> getAllAuthors() {
		return authorService.getAuthors();
	}
	
	public List<BookGenre> getAllBookGenres() {
		return bookGenreService.getBookGenres();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {System.out.println("!");
		this.book = book;
	}

	public Book getFormBook() {
		return formBook;
	}

	public void setFormBook(Book formBook) {
		this.formBook = formBook;
	}

	public ResourceBundle getMsg() {
		return msg;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

}
