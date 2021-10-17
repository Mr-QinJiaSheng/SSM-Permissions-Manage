package com.kzfire.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzfire.portal.base.BaseService;
import com.kzfire.portal.dao.DeptDao;
import com.kzfire.portal.entiy.SysDept;
import com.kzfire.portal.entiy.SysUserDept;

@Service
public class DeptService  extends BaseService{
	@Autowired
	DeptDao deptDao;

	public Integer saveDept(SysDept dept) {
		if(dept.getDeptId()==null)
		{
			return deptDao.addDept(dept);
		}else
		{
			deptDao.updateDept(dept);
			return dept.getDeptId();
		}
	}

	public List<SysDept> getAllDept() {
		return deptDao.getAllDept();
	}

	public SysDept getDeptById(int deptId) {
		return deptDao.getDeptById(deptId);
	}
	
	@Transactional(rollbackFor=RuntimeException.class)
	public void delDeptById(int deptId) throws Exception{
		//检查是否有下级部门，如果有就不让删除
		List<SysDept>  childs=deptDao.getChildrenById(deptId);
		if(childs!=null&&childs.size()>0)
		{
			throw  new Exception("存在子部门!");
		}else
		{
			deptDao.delDept(deptId);
			//同时删除部门员工关系
			deptDao.delUserDeptByDept(deptId);
		}
	}

	/**
	 * 更改员工部门
	 * @param userId
	 * @param deptId
	 */
	@Transactional(rollbackFor=RuntimeException.class)
	public void saveUserdept(Integer userId, Integer deptId) {
		deptDao.delUserDeptByUser(userId);
		SysUserDept sysUserDept=new SysUserDept();
		sysUserDept.setDeptId(deptId);
		sysUserDept.setUserId(userId);
		deptDao.addUserDept(sysUserDept);
	}
}
