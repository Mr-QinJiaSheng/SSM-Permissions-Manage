package com.kzfire.portal.entiy;

import java.io.Serializable;

public class SysUserDept implements Serializable{
	private Integer id;
	private Integer userId;
	private Integer deptId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
}
