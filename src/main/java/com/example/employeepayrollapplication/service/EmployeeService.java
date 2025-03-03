package com.example.employeepayrollapplication.service;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.exception.EmployeeNotFoundException;
import com.example.employeepayrollapplication.model.Employee;
import com.example.employeepayrollapplication.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getName(),
                employeeDTO.getSalary(),
                employeeDTO.getGender(),
                employeeDTO.getStartDate(),
                employeeDTO.getNote(),
                employeeDTO.getProfilePic(),
                employeeDTO.getDepartment()
        );
        employee = employeeRepository.save(employee); // Save to DB
        log.info("ADDED EMPLOYEE: " + employee);
        return convertToDTO(employee);
    }

    // Get all Employees
    public List<Employee> getAllEmployees() {
        log.info("GET ALL EMPLOYEES FROM DB");
        return employeeRepository.findAll();
    }

    // Get Employee by ID with Exception Handling
    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with ID: " + id);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            log.warn("Employee with ID " + id + " not found! ");
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Update Employee by ID with Exception Handling
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        log.info("Updating Employee with ID: {}", id);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee existingEmployee  = employeeOptional.get();
            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setSalary(employeeDTO.getSalary());
            existingEmployee.setGender(employeeDTO.getGender());
            existingEmployee.setStartDate(employeeDTO.getStartDate());
            existingEmployee.setNote(employeeDTO.getNote());
            existingEmployee.setProfilePic(employeeDTO.getProfilePic());
            existingEmployee.setDepartment(employeeDTO.getDepartment());

            Employee updatedEmployee = employeeRepository.save(existingEmployee); // Update in DB
            log.info("UPDATED EMPLOYEE: " + updatedEmployee);
            return convertToDTO(updatedEmployee);
        } else {
            log.warn("Employee with ID " + id + " not found!");
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
        }
    }

    // Delete Employee by ID with Exception Handling
    public boolean deleteEmployee(Long id) {
        log.info("Deleting Employee with ID: " + id);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employeeRepository.delete(employee); // Delete from DB
            log.info("DELETED EMPLOYEE: " + employee);
            return true;
        } else {
            log.warn("Employee with ID " + id + " not found");
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
        }
    }

    //Convert Employee entity to DTO
    private EmployeeDTO convertToDTO(Employee employee) {
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
}
