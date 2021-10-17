package com.kzfire.portal.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserVo implements Serializable{
	private Integer id;
	private String  account;
	private String realName;
	private String deptName;
	private String mobile;
	private Timestamp joinTime;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Timestamp getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Timestamp joinTime) {
		this.joinTime = joinTime;
	}
	
}
