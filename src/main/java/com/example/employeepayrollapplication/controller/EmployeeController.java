package com.example.employeepayrollapplication.controller;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.model.Employee;
import com.example.employeepayrollapplication.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;


@Slf4j
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage() {
        return ResponseEntity.ok("Welcome to Employee Payroll App!");
    }

    // Create Employee with Validation
    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.debug("Received Employee Data: {}", employeeDTO);
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);
        log.info("Employee created successfully with Name: {}", savedEmployee.getName());
        return ResponseEntity.ok(savedEmployee);
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        log.info("Fetching all employees");
        List<Employee> employees = employeeService.getAllEmployees();
        log.info("Total Employees Retrieved: {}", employees.size());
        return ResponseEntity.ok(employees);
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with ID : {}", id);
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    // Update Employee with Validation
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating employee with ID: {}", id);
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        log.info("Employee updated successfully: {}", updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee By Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        log.warn("Received request to delete employee with ID: {}", id);
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            log.warn("Employee with ID: {} deleted successfully", id);
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            log.warn("Employee with ID: {} not found", id);
            return ResponseEntity.status(404).body("Employee not found");
        }
    }

    //Fetch employees by department
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        log.info("Fetching employees in Sales department");
        return employeeService.getEmployeesByDepartment(department);
    }
}