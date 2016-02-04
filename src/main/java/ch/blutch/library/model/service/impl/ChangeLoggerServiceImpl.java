package ch.blutch.library.model.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ch.blutch.library.model.service.ChangeLoggerService;

@Service
@Scope("request")
public class ChangeLoggerServiceImpl implements ChangeLoggerService {

	public static final String ADD = "Ajout";
	public static final String EDIT = "Modification";
	public static final String DELETE = "Suppression";
	
	public ChangeLoggerServiceImpl() {}
	
	@Override
	public void log(String type, String what) {
		System.out.println(type + " : " + what);
	}

}
