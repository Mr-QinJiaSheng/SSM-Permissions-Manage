package com.kzfire.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzfire.portal.base.BaseService;
import com.kzfire.portal.dao.PermissionDao;
import com.kzfire.portal.entiy.SysPermission;
import com.kzfire.portal.vo.ConditionVo;

/**
 * @author ysf
 *
 * 2015年4月2日 下午3:23:28  
 */
@Service
public class PermissionService extends BaseService{
	@Autowired
	PermissionDao permissionDao;

	public List<SysPermission> getList(ConditionVo cvo) {
		return permissionDao.getList(cvo);
	}

	
	public void saveShop(SysPermission per) {
			if(per.getId()==null)
			{
				permissionDao.addPermission(per);
			}else
			{
				permissionDao.editPermission(per);
			}
	}



	@Transactional(rollbackFor=RuntimeException.class)
	public void delPermissionById(int perId) {
		permissionDao.delPermissionById(perId);//删除权限
		//同时删除权限角色关系
		permissionDao.delRolePerById(perId);
	}




	public Integer savePermission(SysPermission per) {
		if(per.getId()==null)
		{
			return permissionDao.addPermission(per);
		}else
		{
			permissionDao.editPermission(per);
			return per.getId();
		}
	}


	public SysPermission getPermissionById(int perId) {
		return permissionDao.getPermissionById(perId);
	}

}
