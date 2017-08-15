package com.jfeesoft.kindergarten.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Permission;
import com.jfeesoft.kindergarten.view.utils.Utils;

import lombok.Getter;
import lombok.Setter;

@Component("permissionView")
@Scope("view")
public class PermissionView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Getter
	@Setter
	private LazyDataModel<Permission> permissionLazyModel;

	@Getter
	@Setter
	private String perName;

	@Getter
	@Setter
	private String perComp;

	@Getter
	@Setter
	private Permission selectedPermission;

	public void permissionEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Document Edited", ((TreeNode) event.getObject()).toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void permissionEditCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((TreeNode) event.getObject()).toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void delete() {
		Utils.addDetailMessage("Permission deleted");
	}

	public void onRowDblSelect(SelectEvent event) {
		Permission permision = ((Permission) event.getObject());
		perName = permision.getName();
		perComp = permision.getComponent();
	}

	public void clear() {
		perName = null;
		perComp = null;
	}

	public void save() {
		Utils.addDetailMessage("Nowe uprawnienie dodane " + perName + ", " + perComp, FacesMessage.SEVERITY_INFO);
		clear();
	}

}
