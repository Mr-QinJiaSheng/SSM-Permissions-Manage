package com.kzfire.portal.dao;

import java.util.List;

import com.kzfire.portal.entiy.SysRole;
import com.kzfire.portal.vo.ConditionVo;

public interface RoleDao {

	List<SysRole> getList(ConditionVo cvo);

	void addRole(SysRole role);

	void editShop(SysRole role);

	SysRole getRoleById(Integer roleId);

	void delRoleById(Integer roleId);

	void delPerRoleById(Integer roleId);

	void delUserRoleById(Integer roleId);
	
}
