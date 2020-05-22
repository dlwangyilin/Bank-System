package com.et.dao;

import com.et.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
