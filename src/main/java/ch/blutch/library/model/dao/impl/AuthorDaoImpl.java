package ch.blutch.library.model.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import ch.blutch.library.model.dao.AuthorDao;
import ch.blutch.library.model.entity.Author;

@Repository
@Scope("request")
public class AuthorDaoImpl extends GenericDao implements AuthorDao {

	@Override
	public List<Author> getAuthors() {
		DetachedCriteria dc = DetachedCriteria.forClass(Author.class, "a")
				.addOrder(Order.asc("a.lastname"))
				.addOrder(Order.asc("a.firstname"));
		
		return (List<Author>) getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public Author getAuthor(int id) {
		return getHibernateTemplate().get(Author.class, id);
	}

	@Override
	public void addAuthor(Author author) {
		getHibernateTemplate().saveOrUpdate(author);
	}

	@Override
	public void editAuthor(Author author) {
		getHibernateTemplate().saveOrUpdate(author);
	}

	@Override
	public void deleteAuthor(Author author) {
		getHibernateTemplate().delete(author);
	}

}
