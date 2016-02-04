package ch.blutch.library.model.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ch.blutch.library.model.dao.BookDao;
import ch.blutch.library.model.entity.Book;

@Repository
@Scope("request")
public class BookDaoImpl extends GenericDao implements BookDao {

	@Override
	public List<Book> getBooks() {
		DetachedCriteria dc = DetachedCriteria.forClass(Book.class, "b")
				.addOrder(Order.asc("b.title"));
		
		return (List<Book>) getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public Book getBook(int bookId) {
		return getHibernateTemplate().get(Book.class, bookId);
	}

	@Override
	public void addBook(Book book) {
		getHibernateTemplate().saveOrUpdate(book);
	}

	@Override
	public void editBook(Book book) {
		getHibernateTemplate().saveOrUpdate(book);
	}

	@Override
	public void deleteBook(Book book) {
		getHibernateTemplate().delete(book);
	}

}
