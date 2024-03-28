package com.Employee.Services;

import com.Employee.Entity.Employee;
import com.Employee.Repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    private EmployeeRepo employeeRepo;

    public EmployeeServices(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // crud

    public Employee createEmployee(Employee employee) {
        return this.employeeRepo.save(employee);
    }

    public Employee getEmployeeByName(String name) {
        return this.employeeRepo.findByName(name);
    }

    public Employee getEmployeeByEmail(String email) {
        return this.employeeRepo.findByEmail(email);
    }

    public Employee getEmployeeById(int id) {
        return this.employeeRepo.findById(id);
    }

    public void deleteEmployeeByName(String name) {
        this.employeeRepo.deleteByName(name);
    }

    public void deleteEmployeeByEmail(String email) {
        this.employeeRepo.deleteByEmail(email);
    }

    public void deleteEmployeeById(int id) {
        this.employeeRepo.deleteById(id);
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = this.employeeRepo.findById(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        return this.employeeRepo.save(existingEmployee);
    }

    public List<Employee> getAllEmployees() {
        return this.employeeRepo.findAll();
    }
}
