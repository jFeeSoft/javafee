package com.jfeesoft.kindergarten.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
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

	private TreeNode[] selectedPermissionNode;
	private String perName;
	private String perComp;
	private TreeNode root;

	public void permissionEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Document Edited", ((TreeNode) event.getObject()).toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void permissionEditCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((TreeNode) event.getObject()).toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void delete() {
		Utils.addDetailMessage(selectedPermissionNode.length + " cars deleted successfully!");
	}

	public void clear() {
		perName = null;
		perComp = null;
	}

	public void save() {
		Utils.addDetailMessage("Nowe uprawnienie dodane " + perName + ", " + perComp, FacesMessage.SEVERITY_INFO);
		clear();
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerComp() {
		return perComp;
	}

	public void setPerComp(String perComp) {
		this.perComp = perComp;
	}

	public TreeNode[] getSelectedPermissionNode() {
		return selectedPermissionNode;
	}

	public void setSelectedPermissionNode(TreeNode[] selectedPermissionNode) {
		this.selectedPermissionNode = selectedPermissionNode;
	}

}
