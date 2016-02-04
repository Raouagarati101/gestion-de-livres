package ch.blutch.library.model.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ch.blutch.library.model.dao.BookGenreDao;
import ch.blutch.library.model.entity.BookGenre;

@Repository
@Scope("request")
public class BookGenreDaoImpl extends GenericDao implements BookGenreDao {

	@Override
	public List<BookGenre> getBookGenres() {
		DetachedCriteria dc = DetachedCriteria.forClass(BookGenre.class, "g")
				.addOrder(Order.asc("g.description"));
		
		return (List<BookGenre>) getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public BookGenre getBookGenre(int id) {
		return getHibernateTemplate().get(BookGenre.class, id);
	}

	@Override
	public void addBookGenre(BookGenre bookGenre) {
		getHibernateTemplate().saveOrUpdate(bookGenre);
	}

	@Override
	public void editBookGenre(BookGenre bookGenre) {
		getHibernateTemplate().saveOrUpdate(bookGenre);
	}

	@Override
	public void deleteBookGenre(BookGenre bookGenre) {
		getHibernateTemplate().delete(bookGenre);
	}

}
