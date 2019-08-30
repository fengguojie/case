package com.jellard.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
	
	public String k;
	public Integer age;
	public String hello;
	public Date birthday;
	public double grade;
	
	public String getK() {
	    return k;
	}
	public void setK(String k) {
	    this.k = k;
	}
	public Integer getAge() {
	    return age;
	}
	public void setAge(Integer age) {
	    this.age = age;
	}
	public String getHello() {
		return hello;
	}
	public void setHello(String hello) {
		this.hello = hello;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("K=").append(this.getK());
		sBuffer.append("age=").append(this.getAge());
		sBuffer.append("hello=").append(this.getHello());
		sBuffer.append("birthday=").append(sdf.format(this.getBirthday()));
		sBuffer.append("grade=").append(this.getGrade());
		return sBuffer.toString();
	}

}
