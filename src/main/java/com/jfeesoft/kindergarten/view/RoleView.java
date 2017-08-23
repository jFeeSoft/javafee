package com.jfeesoft.kindergarten.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.model.DualListModel;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Permission;
import com.jfeesoft.kindergarten.model.Role;
import com.jfeesoft.kindergarten.service.PermissionService;
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
	private DualListModel<Permission> permissions;

	@Getter
	@Setter
	private Role newRole;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	private List<Permission> permissionSource;

	@PostConstruct
	public void init() {
		permissionSource = (List<Permission>) permissionService.findAll();
		permissions = new DualListModel<Permission>(new ArrayList<Permission>(), new ArrayList<Permission>());

	}

	public void add() {
		newRole = new Role();
		permissions.getTarget().clear();
		permissions.getSource().clear();
		permissions.getSource().addAll(permissionSource);
	}

	public void edit(Role entity) {
		permissions.getTarget().clear();
		permissions.getSource().clear();
		permissions.getTarget().addAll(entity.getPermissions());
		permissions.getSource().addAll(permissionSource);
		permissions.getSource().removeAll(entity.getPermissions());
		newRole = entity;
	}

	public void delete(Role entity) {
		roleService.delete(entity);
		Utils.addDetailMessage(messagesBundle.getString("role.info.delete"), FacesMessage.SEVERITY_INFO);
	}

	public void save() {
		newRole.getPermissions().clear();
		newRole.getPermissions().addAll(permissions.getTarget());
		newRole = roleService.save(newRole);
		Utils.addDetailMessage(messagesBundle.getString("role.info.edit"), FacesMessage.SEVERITY_INFO);
	}

}
