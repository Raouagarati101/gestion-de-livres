package ch.blutch.library.controller.converters;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.blutch.library.model.entity.Author;
import ch.blutch.library.model.entity.Book;
import ch.blutch.library.model.service.AuthorService;
import ch.blutch.library.model.service.BookService;

@Component
@Scope("request")
@ManagedBean
@RequestScoped
public class AuthorConverter implements Converter {

	@Autowired
	@Qualifier("authorServiceImpl")
	private AuthorService authorService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
		if (submittedValue == null || submittedValue.isEmpty()) {
			return null;
		}

		try {
			return authorService.getAuthor(Integer.valueOf(submittedValue));
		} catch (NumberFormatException e) {
			throw new ConverterException(
					new FacesMessage(String.format("%s n'est pas un identifiant valide.", submittedValue)), e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		if (modelValue == null) {
			return "";
		}

		if (modelValue instanceof Author) {
			return String.valueOf(((Author) modelValue).getId());
		} else {
			throw new ConverterException(new FacesMessage(String.format("%s n'est pas un identifiant valide.", modelValue)));
		}
	}

}
