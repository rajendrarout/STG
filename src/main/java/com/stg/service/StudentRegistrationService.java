package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.bean.StudentRegistrationinfo;
import com.stg.entity.StudentRegistration;
import com.stg.repository.StudentRegistrationRepository;

@Service

public class StudentRegistrationService {
	@Autowired
	StudentRegistrationRepository StudentRegistrationRepository;
	
	 public StudentRegistration register(StudentRegistrationinfo studentRegistrationinfo)
	 {
		 return StudentRegistrationRepository.save(studentRegistrationinfo.convertedToEntity());
		 
  	 }
	 public StudentRegistration update(StudentRegistration studentRegistration) {
		 return StudentRegistrationRepository.save(studentRegistration);
	 }
	 public String checkRegistration(String newuserName) {
		 StudentRegistration existingUser = StudentRegistrationRepository.findByUserName(newuserName);
		 if(existingUser != null) {
			 return "UserName already registered.";
		 }
		 else {
			 return "Registration successful.";
		 }
	 }
	 public List<StudentRegistration> getAll(){
		 return StudentRegistrationRepository.findAll();
		 
	 }
	 public Optional<StudentRegistration> getById(Long id){
		 return StudentRegistrationRepository.findById(id);
	 }
 
}
