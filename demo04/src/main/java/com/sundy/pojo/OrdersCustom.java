package com.sundy.pojo;

public class OrdersCustom extends Orders{
	
	//用户名称
	private String username;
	
	//性别
    private String sex;

    //生日
	private String birthday;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
