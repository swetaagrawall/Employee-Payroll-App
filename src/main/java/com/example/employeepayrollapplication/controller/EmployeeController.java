package com.example.employeepayrollapplication.controller;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeePayrollService;

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    @PostMapping("/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    @PutMapping("/update")
    public String updateEmployee() {
        return "Employee updated successfully!";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee() {
        return "Employee deleted successfully!";
    }

    @GetMapping("/get")
    public EmployeeDTO getEmployeeDetails() {
        // Calling service to fetch employee details
        return employeePayrollService.getEmployeeDetails();
    }
}