package com.jfeesoft.kindergarten.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

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
public class PermissionView extends GenericView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Getter
	@Setter
	private LazyDataModel<Permission> permissionLazyModel;

	@Getter
	@Setter
	private Permission newPermission;

	@Autowired
	private PermissionService permissionService;

	public void add() {
		newPermission = new Permission();
	}

	public void edit(Permission entity) {
		newPermission = entity;
	}

	public void delete(Permission entity) {
		permissionService.delete(entity);
		Utils.addDetailMessage(messagesBundle.getString("permission.info.delete"), FacesMessage.SEVERITY_INFO);
	}

	public void save() {
		newPermission = permissionService.save(newPermission);
		Utils.addDetailMessage(messagesBundle.getString("permission.info.edit"), FacesMessage.SEVERITY_INFO);
	}

}
