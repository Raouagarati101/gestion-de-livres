package ch.blutch.library.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
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
public class BookGenreController implements Serializable {

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
	
	private int bookGenreId;
	private BookGenre formBookGenre;
	private BookGenre bookGenre;
	private List<BookGenre> bookGenres;
	
	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		msg = context.getApplication().getResourceBundle(context, "msg");
	}
	
	public void initIndexAction() {
		bookGenres = bookGenreService.getBookGenres();
	}
	
	public void initViewAction() throws IOException {
		bookGenre = bookGenreService.getBookGenre((int) bookGenreId);

		if (bookGenre == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.setResponseStatus(404);
			ec.redirect(ec.getRequestContextPath() + "/404");
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	public void initAddAction() {
		formBookGenre = new BookGenre();
	}
	
	public void initEditAction() throws IOException {
		formBookGenre = bookGenreService.getBookGenre((int) bookGenreId);

		if (formBookGenre == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.setResponseStatus(404);
			ec.redirect(ec.getRequestContextPath() + "/404");
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	public void initDeleteAction() throws IOException {
		bookGenre = bookGenreService.getBookGenre((int) bookGenreId);

		if (bookGenre == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.setResponseStatus(404);
			ec.redirect(ec.getRequestContextPath() + "/404");
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	public String addBookGenre() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		bookGenreService.addBookGenre(formBookGenre);
		context.addMessage(null, new FacesMessage("Genre ajouté."));
		this.bookGenreId = formBookGenre.getId();
		System.out.println(changeLoggerService);
		System.out.println(msg);
		changeLoggerService.log(ChangeLoggerServiceImpl.ADD, msg.getString("bookgenre.add.flashbag"));
		
		return "pretty:bookgenre-view";
	}
	
	public String editBookGenre() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		bookGenreService.editBookGenre(formBookGenre);
		context.addMessage(null, new FacesMessage(msg.getString("bookgenre.edit.flashbag")));
		changeLoggerService.log(ChangeLoggerServiceImpl.EDIT, "Genres");
		
		return "pretty:bookgenre-view";
	}
	
	public String deleteBookGenre() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		bookGenreService.deleteBookGenre(bookGenre);
		context.addMessage(null, new FacesMessage(msg.getString("bookgenre.delete.flashbag")));
		changeLoggerService.log(ChangeLoggerServiceImpl.DELETE, "Genres");
		
		return "pretty:bookgenre-list";
	}

	public int getBookGenreId() {
		return bookGenreId;
	}

	public void setBookGenreId(int bookGenreId) {
		this.bookGenreId = bookGenreId;
	}

	public BookGenre getFormBookGenre() {
		return formBookGenre;
	}

	public void setFormBookGenre(BookGenre formBookGenre) {
		this.formBookGenre = formBookGenre;
	}

	public BookGenre getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(BookGenre bookGenre) {
		this.bookGenre = bookGenre;
	}

	public List<BookGenre> getBookGenres() {
		return bookGenres;
	}

	public void setBookGenres(List<BookGenre> bookGenres) {
		this.bookGenres = bookGenres;
	}
	
}
