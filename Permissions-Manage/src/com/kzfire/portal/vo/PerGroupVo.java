package com.kzfire.portal.vo;

import java.io.Serializable;
import java.util.List;

public class PerGroupVo implements Serializable{
	private String group;
	private List<PermissionVo> per;
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<PermissionVo> getPer() {
		return per;
	}
	public void setPer(List<PermissionVo> per) {
		this.per = per;
	}
	

}
