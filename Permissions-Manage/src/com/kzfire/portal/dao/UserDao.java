package com.kzfire.portal.dao;

import java.util.List;

import com.kzfire.portal.entiy.LoginLog;
import com.kzfire.portal.entiy.SysPermission;
import com.kzfire.portal.entiy.SysRole;
import com.kzfire.portal.entiy.SysUser;
import com.kzfire.portal.entiy.SysUserRole;
import com.kzfire.portal.vo.ConditionVo;
import com.kzfire.portal.vo.UserRoleVo;
import com.kzfire.portal.vo.UserVo;

public interface UserDao {

	SysUser getSysUserByName(String username);

	List<SysRole> getRolesByUserId(Integer id);

	List<SysPermission> getPermsByUserId(Integer id);

	List<UserVo> getList(ConditionVo cvo);

	Integer addUser(SysUser user);

	void updateUser(SysUser user);

	SysUser getSysUserById(Integer id);

	int getUserCount(ConditionVo cvo);

	List<UserRoleVo> getUserRoleVo(Integer userId);

	void delRoleByUserId(Integer userId);

	Integer addUserRole(SysUserRole role);

	void saveLoginLog(LoginLog log);
	
}
