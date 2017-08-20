package com.jfeesoft.kindergarten.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Permission;
import com.jfeesoft.kindergarten.service.PermissionService;
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

	@Autowired
	private PermissionService permissionService;

	public void delete(ActionEvent actionEvent) {
		permissionService.delete(selectedPermission);
		Utils.addDetailMessage("Permission deleted", FacesMessage.SEVERITY_INFO);
	}

	public void onRowDblSelect(SelectEvent event) {
		Permission permision = ((Permission) event.getObject());
		perName = permision.getName();
		perComp = permision.getComponent();
	}

	public void clear(ActionEvent actionEvent) {
		perName = null;
		perComp = null;
	}

	public void save(ActionEvent actionEvent) {
		Permission newPermission = new Permission(null, perName, perComp);
		newPermission = permissionService.save(newPermission);
		Utils.addDetailMessage("Nowe uprawnienie dodane " + perName + ", " + perComp, FacesMessage.SEVERITY_INFO);
		clear(null);
	}

}
