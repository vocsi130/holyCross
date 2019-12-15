package com.cs425.holyCross.service;

import java.util.List;
import java.util.Optional;

import com.cs425.holyCross.model.Patient;

public interface IPatientService {


	 List<Patient> getAllPatients();
	 Patient addNewPatient(Patient patient);
	    Optional<Patient> findByPatientId(Long patientId);
	List<Patient> getAllElderPatients();

}
