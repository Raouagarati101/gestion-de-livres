package ch.blutch.library.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ch.blutch.library.model.dao.BookGenreDao;
import ch.blutch.library.model.entity.BookGenre;
import ch.blutch.library.model.service.BookGenreService;

@Service
@Scope("request")
@Transactional(readOnly = true)
public class BookGenreServiceImpl implements BookGenreService{

	@Autowired @Qualifier("bookGenreDaoImpl")
	private BookGenreDao bookGenreDao;
	
	@Override
	public List<BookGenre> getBookGenres() {
		return bookGenreDao.getBookGenres();
	}

	@Override
	public BookGenre getBookGenre(int id) {
		return bookGenreDao.getBookGenre(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void addBookGenre(BookGenre bookGenre) {
		bookGenreDao.addBookGenre(bookGenre);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void editBookGenre(BookGenre bookGenre) {
		bookGenreDao.editBookGenre(bookGenre);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void deleteBookGenre(BookGenre bookGenre) {
		bookGenreDao.deleteBookGenre(bookGenre);
	}

}
