package com.ecomm.SampleTesting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table


public class ClassTest
{
	
	@Id
	@GeneratedValue
	
	int studentId;
	String studentName;
	String studentPlace;
	public int getStudentId() 
	{
		return studentId;
	}
	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}
	public String getStudentName()
	{
		return studentName;
	}
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	public String getStudentPlace() 
	{
		return studentPlace;
	}
	public void setStudentPlace(String studentPlace)
	{
		this.studentPlace = studentPlace;
	}
	
	
	

}
