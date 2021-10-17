package com.kzfire.portal.dao;

import java.util.List;

import com.kzfire.portal.entiy.SysDept;
import com.kzfire.portal.entiy.SysUserDept;

public interface DeptDao {

	void updateDept(SysDept dept);

	Integer addDept(SysDept dept);

	List<SysDept> getAllDept();

	SysDept getDeptById(int deptId);

	List<SysDept> getChildrenById(int deptId);

	void delDept(int deptId);

	void delUserDeptByDept(int deptId);

	void delUserDeptByUser(Integer userId);

	void addUserDept(SysUserDept sysUserDept);

}
