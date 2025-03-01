package com.example.employeepayrollapplication.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}(\\s[A-Z][a-zA-Z]+)*$", message = "Name must start with a capital letter and have at least characters")
    private String name;
    private long salary;
}