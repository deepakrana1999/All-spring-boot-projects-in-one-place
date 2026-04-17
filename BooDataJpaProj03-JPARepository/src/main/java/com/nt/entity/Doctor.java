package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="JPA_DOCTOR")
public class Doctor {
	@Id
	@Column(name="DOCTOR_ID")
	//auto generated sequence
	//@GeneratedValue
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	//user defind sequence
	//100,101,102,103,etc...
	@SequenceGenerator(name="gen1",sequenceName = "DID_SEQ",allocationSize = 1,initialValue = 100)
	//if we not use user defind sequence default sequence will generates the quence start with 1 and increment by 50
	//1,2,52,102,etc...
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE )
	private Integer did;
	
	@Column(name="DOCTOR_NAME",length=30)
	@NonNull
	private String dname;
	
	@Column(name="DOCTOR_QLFY",length=30)
	@NonNull
	private String qlfy;
	
	@Column(name="DOCTOR_INCOME") 
	@NonNull
	private Long income;
	
	@Column(name="DOCTOR_MOBILENO")
	@NonNull
	private Long mobileNo;
	
	@Column(name="DOCTOR_SPECIALIZATION",length=30)
	@NonNull
	//@Transient
	private String specialization;
	
	public Doctor() {
	       System.out.println("Doctor.Doctor()");
	}
	}

