package com.stg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stg.bean.StudentRegistrationinfo;
import com.stg.entity.StudentRegistration;
import com.stg.repository.StudentRegistrationRepository;
import com.stg.service.StudentRegistrationService;

@RestController
@RequestMapping ("/api/v2/student")

public class StudentRegistrationController {
	

	@Autowired
	StudentRegistrationService studentRegistrationService;
	@Autowired
	StudentRegistrationRepository studentRegistrationRepo;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	StudentRegistration register(@RequestBody StudentRegistrationinfo studentRegistrationinfo){
	return studentRegistrationService.register(studentRegistrationinfo);
	}
	@PutMapping("/edit/{id}")
	Optional<Object> update(@RequestBody StudentRegistration newUser, @PathVariable Long id){
		return studentRegistrationRepo.findById(id)
		.map(user -> {
			user.setStudentName(newUser.getStudentName());
			user.setEmailId(newUser.getEmailId());
			user.setDob(newUser.getDob());
			user.setPhoneNo(newUser.getPhoneNo());
			user.setGender(newUser.getGender());
			return studentRegistrationRepo.save(user);
			
			
		});		
	}
	@GetMapping("/getAll/")
	public List<StudentRegistration> getAll(){
	return studentRegistrationRepo.findAll();
	}
	@GetMapping("/getAll/{id}")
	Optional<StudentRegistration> getUserById(@PathVariable Long id){
		return studentRegistrationService.getById(id);
	}
	@DeleteMapping("/deleteAll/{id}")
	String deleteUser(@PathVariable Long id) {
	if(studentRegistrationRepo.existsById(id)) 
	
		studentRegistrationRepo.deleteById(id);
		return "User with id "+id+"has been deleted success.";
	}
	}
	

			

