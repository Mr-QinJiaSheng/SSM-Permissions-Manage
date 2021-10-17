package com.kzfire.portal.vo;

import java.io.Serializable;

import com.kzfire.portal.entiy.SysRole;

public class UserRoleVo implements Serializable{
	private Integer roleId;
	private String roleName;
	private String roleCode;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	private Integer isSel;
	public Integer getIsSel() {
		return isSel;
	}
	public void setIsSel(Integer isSel) {
		this.isSel = isSel;
	}
	
}
