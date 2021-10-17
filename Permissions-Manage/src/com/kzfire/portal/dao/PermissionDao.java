package com.kzfire.portal.dao;

import java.util.List;
import java.util.Map;

import com.kzfire.portal.entiy.SysPermission;
import com.kzfire.portal.entiy.SysRolePermission;
import com.kzfire.portal.vo.ConditionVo;
import com.kzfire.portal.vo.PerGroupVo;
import com.kzfire.portal.vo.PermissionVo;

public interface PermissionDao {

	List<SysPermission> getList(ConditionVo cvo);

	Integer addPermission(SysPermission per);

	void editPermission(SysPermission per);

	void delPermissionById(Integer perId);


	SysPermission getPermissionById(Integer perId);

	List<PerGroupVo> getPerGroupVo();

	List<PermissionVo> getPersByUserAndGroup(Map map);

	void delPermissionByRoleId(Integer roleId);

	void addRolePer(SysRolePermission role);

	void delRolePerById(Integer perId);

	List<SysPermission> getAll();

}
