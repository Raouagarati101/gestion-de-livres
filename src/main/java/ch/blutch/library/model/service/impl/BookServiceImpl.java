package ch.blutch.library.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ch.blutch.library.model.dao.BookDao;
import ch.blutch.library.model.entity.Book;
import ch.blutch.library.model.service.BookService;

@Service
@Scope("request")
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

	@Autowired @Qualifier("bookDaoImpl")
	private BookDao bookDao;
	
	@Override
	public List<Book> getBooks() {
		return bookDao.getBooks();
	}

	@Override
	public Book getBook(int bookId) {
		return bookDao.getBook(bookId);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void editBook(Book book) {
		bookDao.editBook(book);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void deleteBook(Book book) {
		bookDao.deleteBook(book);
	}

}
