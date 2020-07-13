package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Physician;

public interface PhysicianRepository extends JpaRepository<Physician, Integer>{
	
	@Query("select p from Physician p where p.firstName in (?1,?2) and p.lastName  in (?1,?2)")
Optional<Set<Physician>> findByFirstandLastName(String firstName,String lastName);
	
	@Query("select p from Physician p where p.department.id=?1 and p.plan.id=?2 and p.state.id=?3")
	Optional<List<Physician>> findByStateidPlanidandDepartmentid(Integer departmentid, Integer planid, Integer stateid);

}
