package com.cs425.holyCross.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cs425.holyCross.model.Patient;
import com.cs425.holyCross.repository.IPatientRepository;
import com.cs425.holyCross.service.IPatientService;

@Service
public class PatientService implements IPatientService {

	
	@Autowired
	private IPatientRepository patientRepository;
	
	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientRepository.findAll(Sort.by("fullNames"));
	}

	@Override
	public Patient addNewPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public Optional<Patient> findByPatientId(Long patientId) {
		// TODO Auto-generated method stub
		return patientRepository.findById(patientId);
	}

	@Override
	public List<Patient> getAllElderPatients() {
				List<Patient> list=patientRepository.findAll(Sort.by("dateOfBirth"));
				List<Patient> patients=new ArrayList<Patient>();
				for(Patient c:list) {
					if(c.getDateOfBirth().isBefore(LocalDate.now().minusYears(65)))
						patients.add(c);
				}
		return patients;
	}

}
