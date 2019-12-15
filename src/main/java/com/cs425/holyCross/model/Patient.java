package com.cs425.holyCross.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long patientId;
	
	private String patientNumber;
	private String isAnOutPatient;
	private String fullNames;
	
	private String emailAddress; 
	private String contactPhoneNumber;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;

	public Patient() {
	}

	public Patient(String patientNumber, String isAnOutPatient, String fullNames, String emailAddress,
			String contactPhoneNumber, LocalDate dateOfBirth) {
		this.patientNumber = patientNumber;
		this.isAnOutPatient = isAnOutPatient;
		this.fullNames = fullNames;
		this.emailAddress = emailAddress;
		this.contactPhoneNumber = contactPhoneNumber;
		this.dateOfBirth = dateOfBirth;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}


	public String getFullNames() {
		return fullNames;
	}

	public void setFullNames(String fullNames) {
		this.fullNames = fullNames;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIsAnOutPatient() {
		return isAnOutPatient;
	}

	public void setIsAnOutPatient(String isAnOutPatient) {
		this.isAnOutPatient = isAnOutPatient;
	}
	
	
	

}
