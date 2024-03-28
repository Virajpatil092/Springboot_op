package com.Employee.Repo;

import com.Employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);
    Employee findByEmail(String email);
    Employee findById(int id);

    void deleteByName(String name);
    void deleteByEmail(String email);
    void deleteById(int id);
}
