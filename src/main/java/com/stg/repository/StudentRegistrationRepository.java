package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.StudentRegistration;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long>
{
  StudentRegistration findByUserName(String userName);
}
