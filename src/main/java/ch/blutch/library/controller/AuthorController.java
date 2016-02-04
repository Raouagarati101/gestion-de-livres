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
import ch.blutch.library.model.service.AuthorService;
import ch.blutch.library.model.service.BookGenreService;
import ch.blutch.library.model.service.BookService;
import ch.blutch.library.model.service.ChangeLoggerService;
import ch.blutch.library.model.service.impl.ChangeLoggerServiceImpl;

@ManagedBean
@ViewScoped
@Controller
@Scope("view")
public class AuthorController implements Serializable {

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
	
	private int authorId;
	private Author formAuthor;
	private Author author;
	private List<Author> authors;
	
	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		msg = context.getApplication().getResourceBundle(context, "msg");
	}
	
	public void initIndexAction() {
		authors = authorService.getAuthors();
	}
	
	public void initViewAction() throws IOException {
		author = authorService.getAuthor((int) authorId);

		if (author == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.setResponseStatus(404);
			ec.redirect(ec.getRequestContextPath() + "/404");
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	public void initAddAction() {
		formAuthor = new Author();
	}
	
	public void initEditAction() throws IOException {
		formAuthor = authorService.getAuthor((int) authorId);

		if (formAuthor == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.setResponseStatus(404);
			ec.redirect(ec.getRequestContextPath() + "/404");
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	public void initDeleteAction() throws IOException {
		author = authorService.getAuthor((int) authorId);

		if (author == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.setResponseStatus(404);
			ec.redirect(ec.getRequestContextPath() + "/404");
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	public String addAuthor() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		authorService.addAuthor(formAuthor);
		context.addMessage(null, new FacesMessage(msg.getString("author.add.flashbag")));
		this.authorId = formAuthor.getId();
		changeLoggerService.log(ChangeLoggerServiceImpl.ADD, "Auteurs");
		
		return "pretty:author-view";
	}
	
	public String editAuthor() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		authorService.editAuthor(formAuthor);
		context.addMessage(null, new FacesMessage(msg.getString("author.edit.flashbag")));
		changeLoggerService.log(ChangeLoggerServiceImpl.EDIT, "Auteurs");
		
		return "pretty:author-view";
	}
	
	public String deleteAuthor(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		authorService.deleteAuthor(author);
		context.addMessage(null, new FacesMessage(msg.getString("author.delete.flashbag")));
		changeLoggerService.log(ChangeLoggerServiceImpl.DELETE, "Auteurs");
		
		return "pretty:author-list";
	}

	public Author getFormAuthor() {
		return formAuthor;
	}

	public void setFormAuthor(Author formAuthor) {
		this.formAuthor = formAuthor;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
