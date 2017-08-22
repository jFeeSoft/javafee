package com.jfeesoft.kindergarten.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Role;
import com.jfeesoft.kindergarten.service.RoleService;
import com.jfeesoft.kindergarten.view.utils.Utils;

import lombok.Getter;
import lombok.Setter;

@Component("roleView")
@Scope("view")
public class RoleView extends GenericView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Getter
	@Setter
	private LazyDataModel<Role> roleLazyModel;

	@Getter
	@Setter
	private Role newRole;

	@Autowired
	private RoleService roleService;

	public void add() {
		newRole = new Role();
	}

	public void edit(Role entity) {
		newRole = entity;
	}

	public void delete(Role entity) {
		roleService.delete(entity);
		Utils.addDetailMessage(messagesBundle.getString("role.info.delete"), FacesMessage.SEVERITY_INFO);
	}

	public void save() {
		newRole = roleService.save(newRole);
		Utils.addDetailMessage(messagesBundle.getString("role.info.edit"), FacesMessage.SEVERITY_INFO);
	}

}
