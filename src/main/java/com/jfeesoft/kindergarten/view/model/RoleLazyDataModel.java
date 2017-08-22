package com.jfeesoft.kindergarten.view.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfeesoft.kindergarten.model.Role;
import com.jfeesoft.kindergarten.service.RoleService;
import com.jfeesoft.kindergarten.view.utils.ProperSortOrder;

@Component
public class RoleLazyDataModel extends LazyDataModel<Role> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RoleService roleService;

	@SuppressWarnings("unchecked")
	public Role getRowData(String rowKey) {
		ArrayList<Role> roles = ((ArrayList<Role>) this.getWrappedData());
		for (Role role : roles) {
			if (role.getId().intValue() == Integer.parseInt(rowKey)) {
				return role;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(Role role) {
		return role.getId();
	}

	public List<Role> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Role> roles = roleService.load(first, pageSize, sortField, ProperSortOrder.getDirection(sortOrder),
				filters);
		Long count = roleService.countRepositoryFilter(filters);
		this.setRowCount(count.intValue());
		this.setWrappedData(roles);
		return roles;
	}

}
