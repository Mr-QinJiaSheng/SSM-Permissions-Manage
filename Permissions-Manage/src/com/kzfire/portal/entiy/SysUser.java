package com.kzfire.portal.entiy;

import java.io.Serializable;
import java.sql.Timestamp;

public class SysUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//id
	private String account;//登录账户
	private String password;//密码
	private String realName;//真实姓名
	private String idCard;//身份证号
	private Integer sex;//0女 1男
	private Integer age;//年龄
	private Integer isUse;//是否可用 0否  1是
	private Timestamp birthday;//生日
	private Timestamp joinTime;//入职时间
	private Timestamp leftTime;//离职时间
	private Integer jobLvl;//职称登记  null 无 1初级 2终极 3高级
	private String mobile;//手机号
	private String addr;//家庭地址
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getIsUse() {
		return isUse;
	}
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	public Timestamp getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Timestamp joinTime) {
		this.joinTime = joinTime;
	}
	public Timestamp getLeftTime() {
		return leftTime;
	}
	public void setLeftTime(Timestamp leftTime) {
		this.leftTime = leftTime;
	}
	public Integer getJobLvl() {
		return jobLvl;
	}
	public void setJobLvl(Integer jobLvl) {
		this.jobLvl = jobLvl;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
	
}
