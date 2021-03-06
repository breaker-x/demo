package com.bx.model;

import java.io.Serializable;

public class Users implements Serializable{

	private static final long serialVersionUID = -8817998677126548047L;
	
	private final String OBJECT_KEY = "USER";
	private Integer id;

    private String userName;

    private String password;

    private String email;

    private String sex;

    private Integer age;

    private String deleteFlag = "0";

    public Users(String username, Integer age){
    	this.userName = username;
    	this.age = age;
    }
    public Users() {
    	
	}
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

	public String getOBJECT_KEY() {
		return OBJECT_KEY;
	}

	public String getKey(){
		return getUserName();
	}
	@Override
	public String toString(){
		return "username: " + userName + " , " + "age: " + age;
	}
}