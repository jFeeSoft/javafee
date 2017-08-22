package com.jfeesoft.kindergarten.view;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

public abstract class GenericView {

	protected final ResourceBundle messagesBundle;

	public GenericView() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		this.messagesBundle = application.getResourceBundle(context, "msg");
	}

}
