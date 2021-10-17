package com.kzfire.portal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzfire.portal.base.BaseService;
import com.kzfire.portal.dao.PermissionDao;
import com.kzfire.portal.dao.RoleDao;
import com.kzfire.portal.entiy.SysRole;
import com.kzfire.portal.entiy.SysRolePermission;
import com.kzfire.portal.vo.ConditionVo;
import com.kzfire.portal.vo.PerGroupVo;

/**
 * @author ysf
 *
 * 2015年4月2日 下午3:23:28  
 */
@Service
public class RoleService extends BaseService{
	@Autowired
	RoleDao roleDao;
	@Autowired
	PermissionDao permissionDao;
	

	public List<SysRole> getList(ConditionVo cvo) {
		return roleDao.getList(cvo);
	}

	
	public void saveShop(SysRole role) {
			if(role.getRoleId()==null)
			{
				roleDao.addRole(role);
			}else
			{
				roleDao.editShop(role);
			}
	}


	public SysRole getRoleById(Integer roleId) {
		return roleDao.getRoleById(roleId);
	}

	@Transactional(rollbackFor=RuntimeException.class)
	public void delRoleById(Integer roleId) {
		 roleDao.delRoleById(roleId);//删除角色
		 //删除角色会员关系
		 roleDao.delUserRoleById(roleId);
		 //删除角色权限关系
		 roleDao.delPerRoleById(roleId);
	}


	public List<PerGroupVo>  getPerGroupVoByUserId(Integer id) {
		List<PerGroupVo> vos=permissionDao.getPerGroupVo();
		Map map=new HashMap();
		map.put("roleId", id);
		if(vos!=null)
		{
			for(PerGroupVo vo:vos)
			{
				map.put("pid", vo.getGroup());
				vo.setPer(permissionDao.getPersByUserAndGroup(map));
			}
		}
		return vos;
	}


	/**
	 * 保存角色权限
	 * @param roleCode
	 * @param id
	 */
	@Transactional(rollbackFor=RuntimeException.class)
	public void savePermission(String[] roleCode, Integer roleId) {
		// 删除就有的角色权限关系
		permissionDao.delPermissionByRoleId(roleId);
		//添加新的角色和权限的关系
		SysRolePermission role=null;
		role=new SysRolePermission();
		if(roleCode!=null)
		{
			for(String code:roleCode)
			{
				role.setPermissionId(Integer.parseInt(code));
				role.setRoleId(roleId);
				permissionDao.addRolePer(role);
			}
		}
	}

}
