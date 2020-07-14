package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
