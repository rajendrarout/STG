package com.stg.bean;

import com.stg.entity.StudentRegistration;

import lombok.Data;

@Data

public class StudentRegistrationinfo {
	private String id;
	private String studentName;
	private String emailId;
	private String dob;
	private String phoneNo;
	private String gender;
	
	public StudentRegistration convertedToEntity()
	{
		StudentRegistration student=new StudentRegistration();
		if(id!=null  &&  id!="0") 
		student.setId(Long.valueOf(id));
		student.setStudentName(studentName);
		student.setEmailId(emailId);
		student.setDob(dob);
		student.setPhoneNo(phoneNo);
		student.setGender(gender);
		return student;
	}
}
