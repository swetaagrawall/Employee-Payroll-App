package com.example.employeepayrollapplication.service;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<EmployeeDTO> employeeList = new ArrayList<>();

    // Create Employee
    public EmployeeDTO addEmployee(EmployeeDTO employee) {
        employeeList.add(employee);
        return employee;
    }

    //Delete employee by name
    public boolean deleteEmployeeByName(String name){
        for(EmployeeDTO employee:employeeList){
            if(employee.getName().equalsIgnoreCase(name)) {
                employeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    //Update Employee by name
    public EmployeeDTO updateEmployeeByName(String name,EmployeeDTO updatedEmployee){
        for (EmployeeDTO employee:employeeList){
            if(employee.getName().equalsIgnoreCase(name))
            {
                employee.setName(updatedEmployee.getName());
                employee.setSalary(updatedEmployee.getSalary());
                return employee;
            }
        }
        return null;
    }

    //Get List of Employee
    public List<EmployeeDTO> getAllEmployees() {
        return employeeList;
    }

    // Read Employee by Name
    public List<EmployeeDTO> getEmployeesByName(String name) {
        List<EmployeeDTO> matchingEmployees = new ArrayList<>();
        for (EmployeeDTO employee : employeeList) {
            if (employee.getName().equalsIgnoreCase(name)) { // Case-insensitive match
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }
}