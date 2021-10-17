package com.kzfire.portal.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzfire.portal.base.BaseService;
import com.kzfire.portal.dao.UserDao;
import com.kzfire.portal.entiy.LoginLog;
import com.kzfire.portal.entiy.SysPermission;
import com.kzfire.portal.entiy.SysRole;
import com.kzfire.portal.entiy.SysRolePermission;
import com.kzfire.portal.entiy.SysUser;
import com.kzfire.portal.entiy.SysUserRole;
import com.kzfire.portal.utils.MStringUtils;
import com.kzfire.portal.vo.ConditionVo;
import com.kzfire.portal.vo.UserRoleVo;
import com.kzfire.portal.vo.UserVo;

@Service
public class UserService extends BaseService{
	@Autowired
	private UserDao userDao;
	
	
	public SysUser getByUsername(String username) {
		return userDao.getSysUserByName(username);
	}

	public List<SysRole> getRolesByUserId(Integer id) {
		return userDao.getRolesByUserId(id);
	}

	public List<SysPermission> getPermsByUserId(Integer id) {
		return userDao.getPermsByUserId(id);
	}

	public List<UserVo> getList(ConditionVo cvo) {
		return userDao.getList(cvo);
	}

	public Integer  saveUser(SysUser user) {
		if(user.getId()==null)
		{
			return userDao.addUser(user);
		}else
		{
			userDao.updateUser(user);
			return user.getId();
		}
	}

	public SysUser getSysUserById(Integer id) {
		return userDao.getSysUserById(id);
	}

	/**
	 * 离职操作
	 * @param id
	 */
	public void userLeft(Integer id) {
		SysUser user=userDao.getSysUserById(id);
		user.setLeftTime(MStringUtils.getTime());
		user.setIsUse(0);
		userDao.updateUser(user);
	}


	public int getUserCount(ConditionVo cvo) {
		return userDao.getUserCount(cvo);
	}

	public List<UserRoleVo> getUserRoleVo(Integer userId) {
		return userDao.getUserRoleVo(userId);
	}
	@Transactional(rollbackFor=RuntimeException.class)
	public void saveUserRole(String[] roleId, int userId) {
		// 删除旧有的用户角色关系
			userDao.delRoleByUserId(userId);
				//添加新的用户角色关系
				SysUserRole role=null;
				role=new SysUserRole();
				if(roleId != null)
				{
					for(String code:roleId)
					{
						role.setRoleId(Integer.parseInt(code));
						//System.out.println("角色ID码--->" + code );
						role.setUserId(userId);
						
						userDao.addUserRole(role);
					}
				}
		
	}

	public void saveLoginLog(LoginLog log) {
		userDao.saveLoginLog(log);
		
	}

	public void updateUser(SysUser user) {
		userDao.updateUser(user);
		
	}

}
