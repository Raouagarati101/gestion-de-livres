package ch.blutch.library.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ch.blutch.library.model.dao.AuthorDao;
import ch.blutch.library.model.entity.Author;
import ch.blutch.library.model.service.AuthorService;

@Service
@Scope("request")
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {

	@Autowired @Qualifier("authorDaoImpl")
	private AuthorDao authorDao;
	
	@Override
	public List<Author> getAuthors() {
		return authorDao.getAuthors();
	}

	@Override
	public Author getAuthor(int id) {
		return authorDao.getAuthor(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void addAuthor(Author author) {
		authorDao.addAuthor(author);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void editAuthor(Author author) {
		authorDao.editAuthor(author);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void deleteAuthor(Author author) {
		authorDao.deleteAuthor(author);
	}

}
