package com.stg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student")

public class StudentRegistration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String studentName;
	@Column
	private String emailId;
	@Column
	private String dob;
	@Column
    private String phoneNo;
	@Column
	private String gender;
	
}
