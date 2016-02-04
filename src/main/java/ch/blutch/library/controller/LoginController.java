package ch.blutch.library.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@ManagedBean
@ViewScoped
@Controller
@Scope("view")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	public void initLoginAction() {
		
	}
	
	public void login() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
		    ExternalContext extenalContext = FacesContext.getCurrentInstance().getExternalContext();
		    RequestDispatcher dispatcher = ((ServletRequest)extenalContext.getRequest()).getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward((ServletRequest)extenalContext.getRequest(), (ServletResponse)extenalContext.getResponse());
			facesContext.responseComplete();
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
