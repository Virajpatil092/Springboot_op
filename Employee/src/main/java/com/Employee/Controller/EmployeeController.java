package com.Employee.Controller;

import com.Employee.Entity.Employee;
import com.Employee.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/Employee")
    public List<Employee> getAllEmployees() {
        return this.employeeServices.getAllEmployees();
    }

    @GetMapping("/Employee/byid/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        System.out.println("by id");
        return this.employeeServices.getEmployeeById(id);
    }

    @GetMapping("/Employee/byname/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        System.out.println("by name");
        return this.employeeServices.getEmployeeByName(name);
    }

    @GetMapping("/Employee/byemail/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email) {
        System.out.println("by email");
        return this.employeeServices.getEmployeeByEmail(email);
    }

    @DeleteMapping("/Employee/byid/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        this.employeeServices.deleteEmployeeById(id);
    }

    @DeleteMapping("/Employee/byname/{name}")
    public void deleteEmployeeByName(@PathVariable String name) {
        this.employeeServices.deleteEmployeeByName(name);
    }

    @DeleteMapping("/Employee/byemail/{email}")
    public void deleteEmployeeByEmail(@PathVariable String email) {
        this.employeeServices.deleteEmployeeByEmail(email);
    }

    @PutMapping("/Employee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return this.employeeServices.updateEmployee(id, employee);
    }

    @PostMapping("/Employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeServices.createEmployee(employee);
    }
}
