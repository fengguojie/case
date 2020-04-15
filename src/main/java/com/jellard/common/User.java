package com.jellard.common;

import java.math.BigDecimal;

public class User {
	
	long id;
	String name;
	BigDecimal grade;
	
	public User() {}
	
	public User(long id,String name,BigDecimal grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getGrade() {
		return grade;
	}
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("当前的user id:").append(id)
				   .append("|姓名:").append(name)
				   .append("|成绩:").append(grade).toString();
	}

}
