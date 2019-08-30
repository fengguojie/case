package com.jellard.adapter;

import java.math.BigDecimal;

public class Teacher {
	
	public String name;
	public int sex;
	public String salary;
	public String subject;
	public BigDecimal score;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
    public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	@Override
	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("name=").append(this.getName());
		sBuffer.append("sex=").append(this.getSex());
		sBuffer.append("salary=").append(this.getSalary());
		sBuffer.append("subject=").append(this.getSubject());
		sBuffer.append("score=").append(this.getScore());
		return sBuffer.toString();
	}

}
