package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Description;

public interface DescriptionRepository extends JpaRepository<Description, Integer> {

}
