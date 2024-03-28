package com.backend.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.model.Employee;

public interface Employeerepo extends JpaRepository<Employee, Long>{
	public Optional<Employee> findById(Long id);
	public void deleteById(Long id);
}