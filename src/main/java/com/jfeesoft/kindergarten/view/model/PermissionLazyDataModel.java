package com.jfeesoft.kindergarten.view.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Permission;

import lombok.val;

@Component
public class PermissionLazyDataModel extends LazyDataModel<Permission> {

	private static final long serialVersionUID = 1L;
	// private ArrayList<Permission> permissions = new ArrayList<Permission>();

	public Permission getRowData(String rowKey) {
		return ((ArrayList<Permission>) this.getWrappedData()).get(Integer.parseInt(rowKey));
	}

	@Override
	public Object getRowKey(Permission permission) {
		return permission.getId();
	}

	public List<Permission> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		val permissions = new ArrayList<Permission>();
		permissions.add(new Permission(0, "NAME", "COMP_NAME"));
		permissions.add(new Permission(1, "NAME2", "COMP_NAME2"));
		this.setRowCount(permissions.size());
		this.setWrappedData(permissions);
		return permissions;
	}

}
