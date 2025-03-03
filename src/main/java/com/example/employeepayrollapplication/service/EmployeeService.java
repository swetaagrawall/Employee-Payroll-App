package com.example.employeepayrollapplication.service;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.exception.EmployeeNotFoundException;
import com.example.employeepayrollapplication.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1;

    // Create Employee
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                idCounter++,
                employeeDTO.getName(),
                employeeDTO.getSalary(),
                employeeDTO.getGender(),
                employeeDTO.getStartDate(),
                employeeDTO.getNote(),
                employeeDTO.getProfilePic(),
                employeeDTO.getDepartment()
        );
        employeeList.add(employee);
        log.info("ADDED EMPLOYEE: {}", employee);
        return new EmployeeDTO(
                employee.getName(),
                employee.getSalary(),
                employee.getGender(),
                employee.getStartDate(),
                employee.getNote(),
                employee.getProfilePic(),
                employee.getDepartment()
        );
    }

    // Get all Employees
    public List<Employee> getAllEmployees() {
        log.info("GET ALL EMPLOYEES");
        return employeeList;
    }

    // Get Employee by ID with Exception Handling
    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        log.warn("Employee with ID {} not found", id);
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
    }

    // Update Employee by ID with Exception Handling
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        log.info("Updating Employee with ID: {}", id);
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(employeeDTO.getName());
                emp.setSalary(employeeDTO.getSalary());
                emp.setGender(employeeDTO.getGender());
                emp.setStartDate(employeeDTO.getStartDate());
                emp.setNote(employeeDTO.getNote());
                emp.setProfilePic(employeeDTO.getProfilePic());
                emp.setDepartment(employeeDTO.getDepartment());

                log.info("UPDATED EMPLOYEE: {}", emp);
                return new EmployeeDTO(
                        emp.getName(),
                        emp.getSalary(),
                        emp.getGender(),
                        emp.getStartDate(),
                        emp.getNote(),
                        emp.getProfilePic(),
                        emp.getDepartment()
                );
            }
        }
        log.warn("Employee with ID {} not found!", id);
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
    }

    // Delete Employee by ID with Exception Handling
    public boolean deleteEmployee(Long id) {
        log.info("Deleting Employee with ID: {}", id);
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                employeeList.remove(emp);
                log.info("DELETED EMPLOYEE: {}", emp);
                return true;
            }
        }
        log.warn("Employee with ID {} not found", id);
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
    }
}