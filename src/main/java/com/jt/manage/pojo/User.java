package com.jt.manage.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)//忽略未知属性
public class User implements Serializable{
	
	//因为系统模块部署在不同的服务器, 系统间调用,必须序列化对象
	private static final long serialVersionUID = 8564137889476580491L;
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	
	//拼接对象
	public Integer getIds() {
		return id;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
	
	

}
