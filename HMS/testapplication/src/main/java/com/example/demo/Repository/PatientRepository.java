package com.example.demo.Repository;

import java.util.Optional;
import java.util.Set;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	@Query("select p from Patient p where p.firstName in (?1,?2) and p.lastName  in (?1,?2)")
Optional<Set<Patient>> findByFirstandLastName(String firstName,String lastName);

	
	@Query("select p from Patient p where p.firstName in (?1,?2) and p.lastName  in (?1,?2)")
	Optional<Patient> findByfirstandlastName(String firstName,String lastName);
}
