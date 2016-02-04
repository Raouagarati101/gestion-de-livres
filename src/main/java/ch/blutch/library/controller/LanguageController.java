package ch.blutch.library.controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LanguageController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Locale locale;
	private String newLocaleCode;	// Sert à passer un paramètre pour la méthode 'changeLocale()'

	private static Map<String, Object> countries;
	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH);
		countries.put("Français", Locale.FRENCH);
	}
	
	@PostConstruct
	public void init() {
		locale = Locale.FRENCH;
	}

	public void changeLocale() {
		for (Map.Entry<String, Object> entry : countries.entrySet()) {
			if (entry.getValue().toString().equals(newLocaleCode)) {
				locale = (Locale) entry.getValue();
				FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
			}
		}
	}
	
	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	public String getNewLocaleCode() {
		return newLocaleCode;
	}

	public void setNewLocaleCode(String newLocaleCode) {
		this.newLocaleCode = newLocaleCode;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
