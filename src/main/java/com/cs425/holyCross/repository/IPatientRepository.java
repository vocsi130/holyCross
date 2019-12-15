package com.cs425.holyCross.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs425.holyCross.model.Patient;

public interface IPatientRepository  extends JpaRepository<Patient, Long>{

}
