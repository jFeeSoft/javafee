package com.jfeesoft.kindergarten.view.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Permission;
import com.jfeesoft.kindergarten.service.PermissionService;
import com.jfeesoft.kindergarten.view.utils.ProperSortOrder;

@Component
public class PermissionLazyDataModel extends LazyDataModel<Permission> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PermissionService permissionService;

	@SuppressWarnings("unchecked")
	public Permission getRowData(String rowKey) {
		ArrayList<Permission> permissions = ((ArrayList<Permission>) this.getWrappedData());
		for (Permission permission : permissions) {
			if (permission.getId().intValue() == Integer.parseInt(rowKey)) {
				return permission;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(Permission permission) {
		return permission.getId();
	}

	public List<Permission> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Permission> permissions = permissionService.load(first, pageSize, sortField,
				ProperSortOrder.getDirection(sortOrder), filters);
		Long count = permissionService.countPermissionRepositoryFilter(filters);
		this.setRowCount(count.intValue());
		this.setWrappedData(permissions);
		return permissions;
	}

}
